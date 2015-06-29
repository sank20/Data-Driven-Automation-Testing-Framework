import java.io.File;
import java.io.IOException;

public class Report {
public static void main(String args[]) //throws IOException
{
	try{
		
	/*
	String ReportLocation="report.html";
	
	File report= new File(ReportLocation);
	System.out.println(File.separator);
	System.out.println(System.getenv().toString());
	Document rep= Jsoup.parse(report,"UTF-8");
	//System.out.println(rep.select("h2").text().toString());
	System.out.println(rep.getElementsByAttributeValue("id", "Status").text().toString().toLowerCase().contains("fail".toLowerCase()));
	//for(Element a :
	/*if(rep.getElementsContainingText("fail").toString()=="")
		System.out.println("no fail successful");
	else
	{
		System.out.println("fail successful");
		
	}*/
	
		File folder = new File("/home/sanket/Automation/Project/Report/version5/SuiteOne/27-03-15/10-49-34/");
		File[] listOfFiles = folder.listFiles();
		System.out.println(listOfFiles[0].isFile());
		System.out.println(folder.getParentFile());
		String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
		System.out.println(MainPath);
		    /*for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }*/	
		
		}
	finally{}
	//catch(IOException e)
	//{
	//	e.printStackTrace();
	//}
}
}
