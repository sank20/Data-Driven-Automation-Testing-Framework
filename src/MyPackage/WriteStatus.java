package MyPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WriteStatus {
public static void WriteToReport() throws IOException
{
	FileWriter main=null;
	try{
		
	String Test = Fetch_Param.Fetch_Param_From_Properties("TestName");
	String time=Fetch_Param.Fetch_Param_From_Properties("TestExecutionTime");
	String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
	File MainReport= new File(MainPath);
	
	Document mainrep=Jsoup.parse(MainReport, "UTF-8");
	mainrep.select("h2").last().after("<br><h2>Execution Time:"+time+"</h2>");
	main = new FileWriter(MainReport.getParentFile()+File.separator+Test+".html");
	main.write(mainrep.toString());
	
	}
	catch(IOException e){
		System.out.println(e);
	}
	finally{
		main.close();
	}
}
}
