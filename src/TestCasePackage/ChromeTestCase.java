package TestCasePackage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import MyPackage.CreateReport;
import MyPackage.Fetch_Param;
import MyPackage.LogRep;
import MyPackage.SCShot;

public class ChromeTestCase {
	
	//public static void main() throws SecurityException, IOException, InterruptedException
	public void test()throws SecurityException, IOException, InterruptedException
	{
		// set up the driver
	    System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
		//CreateReport report= new CreateReport();
		//report.ResetReport();
WebDriver driver = new ChromeDriver();
Fetch_Param FetchParam= new Fetch_Param();
LogRep.GenLogger("start of test case one");
 driver.manage().window().maximize();
 driver.get("http://localhost/home.php");
 
 //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

CreateReport.create( "open home.php", "http://localhost/home.php should open ", "actual", "pass", SCShot.captureScreenShots("HomePage"));

driver.get(" http://localhost/book.php");
//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
CreateReport.create( "open book.php", "expected", "actual", "pass", SCShot.captureScreenShots("BookPage"));

driver.get("http://localhost/about.php");
//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
CreateReport.create( "open about.php", "expected", "actual", "pass", SCShot.captureScreenShots("AboutPage"));

driver.get("http://localhost/contact.php");
//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
CreateReport.create( "open contact.php", "expected", "actual", "pass", SCShot.captureScreenShots("ContactPage"));
   


driver.close();
   
LogRep.GenLogger("end of test case one");
	}

}


    