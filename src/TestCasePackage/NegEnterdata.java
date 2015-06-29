package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import MyPackage.CreateReport;
import MyPackage.SCShot;

public class NegEnterdata {
	
	
     static WebDriver driver=new FirefoxDriver();
     
     public static void neg() throws InterruptedException, IOException
     {
    	 
    	
     String actual;
     String msg;
     driver.get("http://localhost/book.php");
	 driver.manage().window().maximize();

     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

    WebElement validate=driver.findElement(By.name("submit1"));
    
    validate.click();
    
    if (!validate.equals(validate))
	{	
    	actual="pass";	
    	msg = "Booking accepted, as all values are entered ";
	}
	else
	{
		
		
	     actual = "fail";
	     msg="As all values are not entered, Booking not accepted";
	
	}
    
	CreateReport.create( "Booking", "Booking accepted,if all values are entered", msg, actual, SCShot.captureScreenShots("Status"));

   
     
    Thread.sleep(2000);
	driver.close();
	}
	
	
}
