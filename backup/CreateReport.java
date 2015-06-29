import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class CreateReport {
	//public static int counter;
	static String MainResult="xyz",TempName="abc";
	static boolean flag=true;
	
	public static void create(String TestCaseName, String TestSteps, String ExpectedResult, String ActualResult, String status, String ScreenshotLocation) throws IOException
	{
		
		FileWriter doc= null;
		FileWriter doc2=null;
		FileWriter main=null;
		Date date= new Date();
		
		try{
		/*doc= new FileWriter("report.html");
		doc.write("<html>");
		doc.append("\n <head> <style> thead{background-color: green; \n color:white;}  table, thead, td {border: 1px solid green;}table {order-collapse: collapse;}table, thead, td {border: 1px solid green;} </style><title> test report </title> </head>");
		doc.append("<body> \n<div id=\"div1\"> <table> \n <thead> <tr> <td> Sr.no </td> \n<td> Name </td> \n<td> pass/fail </td> \n<td> link </td> \n </tr> </thead>\n <tr> <td> 1 </td> \n<td> sanket </td> <td> pass </td> <td> <a href="+google+">click here </a> </td> </table>\n</div> </body>");
		doc.append("\n</html>");
		*/
		
		//String html;
		
		/*StringBuilder html= new StringBuilder();
		html.append("<html> \n <head> <style> thead{background-color: green; \n color:white;}  table, thead, td {border: 1px solid green; border-collapse: collapse;}table, thead, td {border: 1px solid green;} </style><title> test report </title> </head>");
		html.append("<body> \n <table> \n <thead> <tr> <td> Sr.no </td> \n<td> Test Steps </td> \n<td> pass/fail </td> \n<td> link </td> \n </tr> </thead>\n <tr> <td> 1 </td> \n<td> sanket </td> <td> pass </td> <td> <a href="+google+">click here </a> </td> </table>\n </body>");
		html.append("\n</html>");
		String html1= html.toString(); */
		//int sr=count();
			String ReportLocation="report.html";
			File report= new File(ReportLocation);
			File RealReport= new File(TestCaseName+"_report.html");
			//File mainfile = new File("index.html");
			Document rep= Jsoup.parse(report, "UTF-8");
			Element div= rep.select("h2").first();
			div.text(TestCaseName);
			 //rep.select("body").first().before("<h2>"+TestCaseName+"</h2>");	
			rep.select("tr").last().after(" <tr><td></td> <td>"+TestSteps+"</td>  <td>"+ExpectedResult+"</td>  <td>"+ActualResult+"</td><td>"+status+"</td> <td> <a href=\""+ScreenshotLocation+"\"> Screenshot link </a> </td> </tr>");
			
			File MainReport= new File("index.html");
			Document mainrep=Jsoup.parse(MainReport,"UTF-8");
			mainrep.getElementById("machine").text(java.net.InetAddress.getLocalHost().getHostName()); 
			mainrep.getElementById("name").text(System.getProperty("user.name"));
			mainrep.getElementById("date").text(date.toString());
			
			if(TempName.equals(TestCaseName)==true)
			{
				if(flag==true)
				{
					MainResult= status;
				}
				if(MainResult.equalsIgnoreCase("fail")==true)
				{
					flag=false;
				}
				mainrep.select("tr").last().text("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\""+ReportLocation+"\">"+MainResult+"</a></td></tr>");

			}
			else
			{
				TempName=TestCaseName;
				flag=true;
				mainrep.select("tr").last().after("<tr><td></td> <td>"+TestCaseName+"</td> <td> <a href=\""+ReportLocation+"\">"+MainResult+"</a></td></tr>");

			}
		
			System.out.println(rep.toString());
			doc= new FileWriter(report);
			doc.write(rep.toString());
			doc2= new FileWriter(RealReport);
			doc2.write(rep.toString());
			main = new FileWriter(MainReport);
			main.write(mainrep.toString());
			//counter++;
			doc.close();
			doc2.close();
		}
		catch(IOException e)
		{
			System.out.println("create report exception" +e);
		}
		finally{
			//doc.close();
			//doc2.close();
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

}
	
	


	
	
