package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import MyPackage.CreateReport;
import MyPackage.LogRep;
import MyPackage.SCShot;

public class CalcNegTest {

	static WebDriver driver =  new FirefoxDriver();

	public static void calci() throws SecurityException, IOException, InterruptedException
	{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
			
		driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");	
		
		driver.manage().window().maximize();
		
		LogRep.GenLogger("Calculator is opened for testing");
		
		SCShot.captureScreenShots("HTML Calci");
		
		WebElement e = driver.findElement(By.id("4"));
		e.click();
		
		String actual;
		String msg;
		
		if (!e.equals(e))
		{	
			actual="pass";	
			msg = "Correct value of the button is entered";
			
			
         
		}
		else
		{
			actual = "fail";
	         msg="Instead of entering 4, 5 has been entered and it is a wrong value";
		
		}
        
		
		LogRep.GenLogger(" Instead of 4, 5 has been entered");
		
		
        CreateReport.create( "Button Value Verification", "Value assigned to the button must be right", msg, actual, SCShot.captureScreenShots("Result3"));
  
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
		
		driver.close();
		
		
		
		
	}
}
