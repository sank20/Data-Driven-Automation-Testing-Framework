package TestCasePackage;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opera.core.systems.scope.protos.EcmascriptProtos.Object;

import MyPackage.*;
@Test
public class TestDataBaseEntry {

	public  void test() throws InterruptedException, SecurityException, UnknownHostException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
		{
		//CreateReport report= new CreateReport();
		//report.ResetReport();
		boolean flag;
		ResultSet rs=null;
				//WebDriver driver = new FirefoxDriver();
				//Fetch_Param FetchParam= new Fetch_Param();
				//LogRep.GenLogger("start of test case one");
				
		        
		      
		      /*
		        driver.get(" http://localhost/book.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open book.php", "expected", "actual", "pass", SCShot.captureScreenShots("BookPage"));
			   
		        driver.get("http://localhost/about.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open about.php", "expected", "actual", "pass", SCShot.captureScreenShots("AboutPage"));
			       
		      
		        driver.get("http://localhost/contact.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open contact.php", "expected", "actual", "pass", SCShot.captureScreenShots("ContactPage"));
			       
		       
		       
				driver.close();
				   
				LogRep.GenLogger("end of test case one");
								
				*/
		
				//boolean flag1=DatabaseConn.Connect("localhost/taxi", "root", "");
				boolean flag1=ConnectToMsAccess.Connect("C:\\DAULAT_RESORT.mdb", "", "");
				
				
				if(flag1==true)
				{System.out.println("return true value  ");
					//rs= (ResultSet) DatabaseConn.Execute("Select * from customer where FirstName=rishi");
					rs= (ResultSet)ConnectToMsAccess.Execute("Select USERNAME from ADMIN");
					//System.out.println(" ENTERED");
				}
				
				
				if(rs!=null)
				{
					while( rs.next())
		               {
		               String name= rs.getString("USERNAME"); 
						//String name= rs.getString("LastName");
		                System.out.println("                         "+name);
		                CreateReport.create( "test MS access", "should be able to fetch data  ", "Fetched Data", "pass", SCShot.captureScreenShots("Console"));
					       
		               }
				}
				else
					  CreateReport.create( "test MS access", "should be able to fetch data  ", "unable to Fetch Data", "Fail", SCShot.captureScreenShots("Console"));
			       
			 //DatabaseConn.CloseConn();
				ConnectToMsAccess.CloseConn();     
				//driver.close();
		}
	
}




