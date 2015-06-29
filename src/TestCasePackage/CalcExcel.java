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

public class CalcExcel {

	static WebDriver driver =  new FirefoxDriver();
	
	public static void calcy() throws SecurityException, IOException, InterruptedException
	{
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
			
		driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");	
		
		driver.manage().window().maximize();
		
		LogRep.GenLogger("Calculator is opened for testing");
		
		SCShot.captureScreenShots("HTML Calci");
		
		WebElement e = driver.findElement(By.id("Resultbox"));
		e.sendKeys(DriverScript.GetTestParameter("par_one"));
		
		LogRep.GenLogger("par_one has been entered");
		SCShot.captureScreenShots("par_one entered");
		
		WebElement h = driver.findElement(By.id("divide"));
		h.click();
		
		LogRep.GenLogger("Divide operation has been selected");
		LogRep.GenLogger(" / has been entered");
		SCShot.captureScreenShots("/ selected");
		
		WebElement i = driver.findElement(By.id("Resultbox"));
		i.sendKeys(DriverScript.GetTestParameter("par_two"));
		
		LogRep.GenLogger("par_two has been entered");
		SCShot.captureScreenShots("par_two entered");

		WebElement g = driver.findElement(By.id("equals"));
		g.click();
		
		String actual;
		String msg;
		
		if (!g.equals(g))
		{	
         actual = "fail";
         msg="The result is not as expected";
		}
		else
		{
		actual="pass";	
		msg = "Result is as expected and correct";
		}
        
		CreateReport.create( "Result verification in calculator", "Result is correct if division is rightly performed", msg, actual, SCShot.captureScreenShots("Result2"));
  
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
		
		driver.close();
		
		
		
	}
	
	
	
}
