
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class CreateReport {
	//public static int counter;
	static String MainResult,TempName;
	static boolean flag;
	
	public static void create(String TestSteps, String ExpectedResult, String ActualResult, String status, String ScreenshotLocation) throws IOException
	{
		
		FileWriter doc= null;
		//FileWriter doc2=null;
		FileWriter main=null;
		Date date= new Date();
		BufferedWriter wr= null; 
		BufferedWriter wr2=null;
		String Test = Fetch_Param.Fetch_Param_From_Properties("TestName");
		String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
		String TestCaseName= Fetch_Param.Fetch_Param_From_Properties("testcasename");
		try{
		/*doc= new FileWriter("report.html");
		doc.write("<html>");
		doc.append("\n <head> <style> thead{background-color: green; \n color:white;}  table, thead, td {border: 1px solid green;}table {order-collapse: collapse;}table, thead, td {border: 1px solid green;} </style><title> test report </title> </head>");
		doc.append("<body> \n<div id=\"div1\"> <table> \n <thead> <tr> <td> Sr.no </td> \n<td> Name </td> \n<td> pass/fail </td> \n<td> link </td> \n </tr> </thead>\n <tr> <td> 1 </td> \n<td> sanket </td> <td> pass </td> <td> <a href="+google+">click here </a> </td> </table>\n</div> </body>");
		doc.append("\n</html>");
		*/
		File f= new File(MainPath);
		File[] list= f.listFiles();
		for(int i=0;i<list.length;i++)
		{
			if(list[i].isFile()==true)
			{
				flag=true;
				break;
			}
			else{
				flag=false;
			}
		}
		
		if(flag==false)
		{
			CreateReport.ResetMainReport();
			System.out.println("\n\nnew main report!!\n\n");
		}	
		//String html;
		
		/*StringBuilder html= new StringBuilder();
		html.append("<html> \n <head> <style> thead{background-color: green; \n color:white;}  table, thead, td {border: 1px solid green; border-collapse: collapse;}table, thead, td {border: 1px solid green;} </style><title> test report </title> </head>");
		html.append("<body> \n <table> \n <thead> <tr> <td> Sr.no </td> \n<td> Test Steps </td> \n<td> pass/fail </td> \n<td> link </td> \n </tr> </thead>\n <tr> <td> 1 </td> \n<td> sanket </td> <td> pass </td> <td> <a href="+google+">click here </a> </td> </table>\n </body>");
		html.append("\n</html>");
		String html1= html.toString(); */
		//int sr=count();
			String ReportLocation="report.html";
			File report= new File(ReportLocation);
			wr=new BufferedWriter(new FileWriter(new File(MainPath+TestCaseName+"_report.html"), false));
			//File mainfile = new File("index.html");
			//File RealReport= new File(TestCaseName+"_report.html");
		System.out.println("file object successful");
		//System.out.println("createnewfile returns:" + RealReport.createNewFile());
		//System.out.println("exists returns:"+ RealReport.exists());

//*****************************************Parse the main report index.html***********************************************************************************************			
			File MainReport= new File("index.html");
			
			Document mainrep=Jsoup.parse(MainReport, "UTF-8");
//***********************************************************************
			Document rep= Jsoup.parse(report,"UTF-8");
			System.out.println("testing if condition:"+TestCaseName.equals(rep.select("h2").text().toString())+"testcasename:"+TestCaseName+"H2 content:"+rep.select("h2").text().toString());
			
			if(TestCaseName.equals(rep.select("h2").text().toString()))    //uses realrep (the report already exists and it needs to be updated
			{
				System.out.println("inside if!!!!!");
				//********************************** Parse the Test case report******************************
				//Document realrep= Jsoup.parse(RealReport, "UTF-8");

				
				rep.select("tr").last().after(" <tr><td></td> <td>"+TestSteps+"</td>  <td>"+ExpectedResult+"</td>  <td>"+ActualResult+"</td><td id=\"status\">"+status+"</td> <td> <a href=\""+ScreenshotLocation+"\"> Screenshot link </a> </td> </tr>");
				System.out.println(" chota report:"+rep.toString());
				//***********************modify the main report index.html**********************************
				
			if(rep.getElementsByAttributeValue("id", "Status").text().toString().toLowerCase().contains("fail")==true)
					mainrep.select("tr").last().html("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\""+MainPath+TestCaseName+"_report.html\"> Fail </a></td></tr>");
			else
					mainrep.select("tr").last().html("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\""+MainPath+TestCaseName+"_report.html\"> Pass </a></td></tr>");
				//*********************************************************************************************************
				
				//doc2= new FileWriter(RealReport);
				//doc2.write(rep.toString());
				doc= new FileWriter(report);
				doc.write(rep.toString());
				wr.write(rep.toString());
				
			}
			else    // Uses rep (when it is the first test step of the test case report)
			{
				System.out.println("inside else!!!!!");

				//RealReport.createNewFile();
				CreateReport reset = new CreateReport();
				reset.ResetReport();
				rep=Jsoup.parse(report,"UTF-8");
				System.out.println("\n\n\nReset kelya nantar:"+rep.toString());
				
				Element div= rep.select("h2").first();
				div.text(TestCaseName);               //could have used .select().first().before() to append but element.text won't make any difference here since it just replaces with same text, and anyway, this block will be entered only once, so no question of replacement.
				//rep.select("body").first().before("<h2>"+TestCaseName+"</h2>");	
				rep.select("tr").last().after(" <tr><td></td> <td>"+TestSteps+"</td>  <td>"+ExpectedResult+"</td>  <td>"+ActualResult+"</td><td id=\"status\">"+status+"</td> <td> <a href=\""+ScreenshotLocation+"\"> Screenshot link </a> </td> </tr>");
				
				//********************************************write to the main report index.html*******************************************
				mainrep.select("tr").last().after("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\""+MainPath+TestCaseName+"_report.html\">"+status+"</a></td></tr>");
				//**********************************************************************************************************
				
				doc= new FileWriter(report);
				doc.write(rep.toString());
				wr.write(rep.toString());
				
				//System.out.println("chota report content(else):"+rep.toString());
				}
						
			 
			mainrep.getElementById("machine").text(java.net.InetAddress.getLocalHost().getHostName()); 
			mainrep.getElementById("name").text(System.getProperty("user.name"));
			mainrep.getElementById("date").text(date.toString());
			
//****************************************old logic, please ignore*******************************************		
	/*		if(TempName.equals(TestCaseName)==true)
			{
				if(flag==true)
				{
					MainResult= status;
				}
				if(MainResult.equalsIgnoreCase("fail")==true)
				{
					flag=false;
				}
				
				System.out.println("check first condition");
			}
			else
			{
				TempName=TestCaseName;
				flag=true;
		
				//System.out.println("entered else");
			}
		
			System.out.println(mainrep.toString());
			
		*/	
//***************************************************************************************************			
			
			main = new FileWriter(MainReport);
			main.write(mainrep.toString());
			wr2=new BufferedWriter(new FileWriter(f.getParentFile()+File.separator+Test+".html"));
			wr2.write(mainrep.toString());
			System.out.println("main report!!!! --------------------\n"+mainrep.toString());
			//counter++;
			doc.close();
			//doc2.close();
			main.close();
			wr.close();
			wr2.close();
		}
		catch(IOException e)
		{
			System.out.println("create report exception  " +e);
		}
		finally{
			//doc.close();
			//doc2.close();
			//main.close();
			//wr.close();
		}
	}
		
	public void ResetReport() throws IOException
	{
		
	try{
	FileWriter reset= null;
	reset= new FileWriter("report.html");
	File res= new File("reset.html");
	Document fresh= Jsoup.parse(res,"UTF-8");
	reset.write(fresh.toString());
	reset.close();
	}
	catch(IOException e)
	{
		System.out.println("reset madhla exeption" +e);
	}
	}

	
	public static void ResetMainReport() throws IOException
	{
		
	try{
		CreateReport abc=new CreateReport();
		abc.ResetReport();
	FileWriter reset= null;
	reset= new FileWriter("index.html");
	File res= new File("resetindex.html");
	Document fresh= Jsoup.parse(res,"UTF-8");
	reset.write(fresh.toString());
	reset.close();
	}
	catch(IOException e)
	{
		System.out.println(" main reset madhla exeption" +e);
	}
	}
}
	
	


	
	
