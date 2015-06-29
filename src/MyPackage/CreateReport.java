package MyPackage;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class CreateReport {
	
	static String MainResult,TempName;
	static boolean flag;
	
	public static void create(String TestSteps, String ExpectedResult, String ActualResult, String status, String ScreenshotLocation) throws IOException
	{
		//initiate IO classes---------------------------------------------------------------------------------------------------------------
		FileWriter doc= null;
		FileWriter main=null;
		Date date= new Date();
		BufferedWriter wr= null; 
		BufferedWriter wr2=null;
		//------------------------------------------------------------------------------------------------------------------------
		//----------Fetch values from properties files----------------------------------------------------------------
		String Test = Fetch_Param.Fetch_Param_From_Properties("TestName");
		String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
		String TestCaseName= Fetch_Param.Fetch_Param_From_Properties("testcasename");
		//-------------------------------------------------------------------------------------------------------------
		try{
		//--------------------------logic to check if the report is new and it's the first row in the report-------------------------------------	
		File f= new File(MainPath);
		File[] list= f.getParentFile().listFiles();
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
			//System.out.println("\n\nnew main report!!\n\n");
		}	
		//------------------------------------------------------------------------------------------------------------------------------------------
			String ReportLocation="report.html";// report.html has to be in the source folder
			File report= new File(ReportLocation);
			wr=new BufferedWriter(new FileWriter(new File(MainPath+TestCaseName+"_report.html"), false));
		
		//System.out.println("file object successful");
		
//*****************************************Parse the main report index.html***********************************************************************************************			
			File MainReport= new File("index.html");
			
			Document mainrep=Jsoup.parse(MainReport, "UTF-8");
//***********************************************************************
			Document rep= Jsoup.parse(report,"UTF-8");//parse the test case report
			//System.out.println("testing if condition:"+TestCaseName.equals(rep.select("h2").text().toString())+"testcasename:"+TestCaseName+"H2 content:"+rep.select("h2").text().toString());
			
			if(TestCaseName.equals(rep.select("h2").text().toString()))    //when it's not the first test step in the report
			{
				//System.out.println("inside if!!!!!");
				//********************************** Parse the Test case report******************************
				
				
				rep.select("tr").last().after(" <tr><td></td> <td>"+TestSteps+"</td>  <td>"+ExpectedResult+"</td>  <td>"+ActualResult+"</td><td id=\"status\">"+status+"</td> <td> <a href=\"file:///"+ScreenshotLocation+"\"> Screenshot link </a> </td> </tr>");
				//System.out.println(" chota report:"+rep.toString());
				
				//***********************modify the main report index.html**********************************
		//------------------logic to test whether the test has passed or failed---------------------------
				
			if(rep.getElementsByAttributeValue("id", "Status").text().toString().toLowerCase().contains("fail")==true){
				
			        mainrep.select("tr").last().html("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\"file:///"+MainPath+"/"+TestCaseName+"_report.html\"><font color=\"red\"> Fail </font></a></td></tr>");
			        WriteToProp st= new WriteToProp();
			        st.WritePropertiesFile("Status","Fail");
			}
			else{
				mainrep.select("tr").last().html("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\"file:///"+MainPath+"/"+TestCaseName+"_report.html\"> Pass </a></td></tr>");
				WriteToProp st= new WriteToProp();
				st.WritePropertiesFile("Status","Pass");
			}
				
		//*********************************************************************************************************
				
				
				doc= new FileWriter(report);
				doc.write(rep.toString());
				wr.write(rep.toString()); // writes the changes back to the testcase report
				
			}
			else    // Uses rep (when it is the first test step of the test case report)
			{
				System.out.println("inside else!!!!!");

				//RealReport.createNewFile();
				CreateReport reset = new CreateReport();
				reset.ResetReport();
				rep=Jsoup.parse(report,"UTF-8");
				//System.out.println("\n\n\nReset kelya nantar:"+rep.toString());
				
				Element div= rep.select("h2").first();
				div.text(TestCaseName);               //could have used .select().first().before() to append but element.text won't make any difference here since it just replaces with same text, and anyway, this block will be entered only once, so no question of replacement.
				
				rep.select("tr").last().after(" <tr><td></td> <td>"+TestSteps+"</td>  <td>"+ExpectedResult+"</td>  <td>"+ActualResult+"</td><td id=\"status\">"+status+"</td> <td> <a href=\"file:///"+ScreenshotLocation+"\"> Screenshot link </a> </td> </tr>");
				
				//********************************************write to the main report index.html*******************************************
				if(status.equalsIgnoreCase("pass")){
					mainrep.select("tr").last().after("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\"file:///"+MainPath+TestCaseName+"_report.html\">"+status+"</a></td></tr>");
					WriteToProp st1= new WriteToProp();
			        st1.WritePropertiesFile("Status","Pass");
				}
				else{
					mainrep.select("tr").last().after("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\"file:///"+MainPath+TestCaseName+"_report.html\"><font color=\"red\">"+status+"</font></a></td></tr>");
					WriteToProp st1= new WriteToProp();
			        st1.WritePropertiesFile("Status","Fail");
				}

				//**********************************************************************************************************
				
				doc= new FileWriter(report);
				doc.write(rep.toString());
				wr.write(rep.toString());
				
			}
						
			//the headers of the main report--------------
			
			mainrep.getElementById("machine").text(java.net.InetAddress.getLocalHost().getHostName()); 
			mainrep.getElementById("name").text(System.getProperty("user.name"));
			mainrep.getElementById("date").text(date.toString());
			
			//-----finally write all the changes back to th respective files----------
			WriteToProp par= new WriteToProp();
			par.WritePropertiesFile("ParentPath", f.getParent());
			main = new FileWriter(MainReport);
			main.write(mainrep.toString());
			wr2=new BufferedWriter(new FileWriter(f.getParentFile()+File.separator+Test+".html"));
			wr2.write(mainrep.toString());
			//System.out.println("main report!!!! --------------------\n"+mainrep.toString());
			
			doc.close();
			
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
		
	//----------functions to reset the report files-------------------
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
	
	


	
	
