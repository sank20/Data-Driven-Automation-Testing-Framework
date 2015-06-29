package MyPackage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Fetch_Version_Package {
	
	public static String Fetch_Param_From_Properties(String Parameter)
	{
		String Parameter_Value=null; 
		 try (FileReader reader = new FileReader("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/src/TestCasePackage/Version_Package.properties")) 
		   {
			Properties properties = new Properties();
			properties.load(reader);
			 Parameter_Value = properties.getProperty(Parameter);
			//System.out.println(Parameter_Value);
		    } catch (IOException e) {
			e.printStackTrace(); return null;
		}
		 if(Parameter_Value.equals(""))
		 {
			 return null;
		 }
		return Parameter_Value;
	}
	//public static void main(String args[])
	
		//{ 
	      // Fetch_Param FetchParam= new Fetch_Param(); 
	      // FetchParam.Fetch_Param_From_Properties("Release");

         //}
}