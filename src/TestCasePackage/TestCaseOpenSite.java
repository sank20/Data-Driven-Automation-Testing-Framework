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
public class TestCaseOpenSite  {

	public  void test() throws InterruptedException, SecurityException, UnknownHostException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
		{
		//CreateReport report= new CreateReport();
		//report.ResetReport();
		boolean flag;
		ResultSet rs=null;
				WebDriver driver = new FirefoxDriver();
				Fetch_Param FetchParam= new Fetch_Param();
				LogRep.GenLogger("start of test case one");
				 driver.manage().window().maximize();
		         driver.get("http://localhost/home.php");
		         //driver.findElement(By.id("f3")).click();
		         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        //flag =SCShot.captureScreenShots();
		       CreateReport.create( "open home.php", "http://localhost/home.php should open ", "actual", "pass", SCShot.captureScreenShots("HomePage"));
			       
		       // if(flag=true)
		       // {
		        //System.out.println("..........................Screenshot taken.............................");
		        //CreateReport.create("Test Case1", "Step no 1", "expected", "actual", "pass", "D:\\Automation\\Project\\Report\\version5\\SuiteOne\\25-29-15_10-29-56\\Screenshot\\2015-03-25_10-30-25.jpg");
		       // }
		        //driver.close();
		        driver.get(" http://localhost/book.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open book.php", "expected", "actual", "pass", SCShot.captureScreenShots("BookPage"));
			       
		        //flag =SCShot.captureScreenShots();
		       // if(flag=true)
		        //{
		        //System.out.println("..........................Screenshot taken.............................");
		        //}
		        driver.get("http://localhost/about.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open about.php", "expected", "actual", "pass", SCShot.captureScreenShots("AboutPage"));
			       
		        //flag =SCShot.captureScreenShots();
		        //if(flag=true)
		        //{
		       // System.out.println("..........................Screenshot taken.............................");
		        //}
		        driver.get("http://localhost/contact.php");
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        CreateReport.create( "open contact.php", "expected", "actual", "pass", SCShot.captureScreenShots("ContactPage"));
			       
		        //flag =SCShot.captureScreenShots();
		        //if(flag=true)
		        //{
		       // System.out.println("..........................Screenshot taken.............................");
		       // }
		       
				driver.close();
				   
				LogRep.GenLogger("end of test case one");
								
				
		/*		////boolean flag1=DatabaseConn.Connect(DB1, DB1_UserName, DB1_Password);
				boolean flag1=DatabaseConn.Connect("localhost/taxi", "root", "");
				//boolean flag1=ConnectToMsAccess.Connect("C:\\DAULAT_RESORT.mdb", "", "");
				
				
				if(flag1==true)
				{System.out.println("return true value  ");
					rs= (ResultSet) DatabaseConn.Execute("Select dest from destination");
					//rs= (ResultSet)ConnectToMsAccess.Execute("Select USERNAME from ADMIN");
					System.out.println(" ENTERED");
				}
				
				
				if(rs!=null)
				{
					while( rs.next())
		               {
		               //String name= rs.getString("USERNAME"); 
						String name= rs.getString("dest");
		                System.out.println("                         "+name);
		               }
				}
			 DatabaseConn.CloseConn();
				//ConnectToMsAccess.CloseConn();     */
				driver.close();
		}
	
}




