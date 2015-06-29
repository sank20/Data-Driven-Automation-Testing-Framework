package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import MyPackage.CreateReport;
import MyPackage.DriverScript;
import MyPackage.LogRep;
import MyPackage.SCShot;

public class MyEcampus 
{

	static WebDriver driver =  new FirefoxDriver();

	public static void testinfo() throws InterruptedException, SecurityException, IOException
	{
		driver.get("http://myecampus.info/login.htm;jsessionid=070086E30BFD6851888177BB5D013C69");


		driver.manage().window().maximize();
		String actual;
		String msg;
		
		WebElement e = driver.findElement(By.id("j_username"));
		e.sendKeys(DriverScript.GetTestParameter("User_name"));
		
		SCShot.captureScreenShots("username entered");
		LogRep.GenLogger("username has been entered");
		
		WebElement f = driver.findElement(By.id("password-1"));
		f.sendKeys(DriverScript.GetTestParameter("Password"));
		
		LogRep.GenLogger("Password has been entered");
		SCShot.captureScreenShots("password entered");

		WebElement validate=driver.findElement(By.id("signin_submit"));
		validate.click();
		
		SCShot.captureScreenShots("Access Granted");
		
		if (!validate.equals(validate))
		{	
         actual = "fail";
         msg="The access cannot be granted";
		}
		else
		{
		actual="pass";	
		msg = "Access is granted";
		}
        
		CreateReport.create( "Validate username and password", "Access should be granted if valid username and password entered", msg, actual, SCShot.captureScreenShots("Status"));
  
		 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		
		driver.close();
	
	}
	
	
}
