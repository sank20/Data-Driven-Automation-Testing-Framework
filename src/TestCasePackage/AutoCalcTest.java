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

public class AutoCalcTest {
	
	static WebDriver driver =  new FirefoxDriver();
	
	public static void cal() throws SecurityException, IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
			
		driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");	
		
		driver.manage().window().maximize();
		
		LogRep.GenLogger("Calculator is opened for testing");
		
		SCShot.captureScreenShots("HTML Calci");
	
		WebElement e = driver.findElement(By.id("1"));
		e.click();
		LogRep.GenLogger("1 has been entered");
		SCShot.captureScreenShots("1 entered");

		WebElement h = driver.findElement(By.id("plus"));
		h.click();
		
		LogRep.GenLogger("Plus operation has been selected");
		LogRep.GenLogger(" + has been entered");
		SCShot.captureScreenShots("+ selected");
		
		WebElement f = driver.findElement(By.id("2"));
		f.click();
		LogRep.GenLogger("2 has been entered");
		SCShot.captureScreenShots("2 entered");

		String actual;
		String msg;
		WebElement g = driver.findElement(By.id("equals"));
		g.click();
		
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
        
		CreateReport.create( "Result verification in calculator", "Result is correct if addition is rightly performed", msg, actual, SCShot.captureScreenShots("Result1"));
  
	
		LogRep.GenLogger("Result of 1+2 is obtained");
		SCShot.captureScreenShots("Result");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);
		
		driver.close();
		
	}

}
