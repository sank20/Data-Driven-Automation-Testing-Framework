package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import MyPackage.CreateReport;
import MyPackage.DriverScript;
import MyPackage.LogRep;
import MyPackage.SCShot;

public class TextBoxEmpty {

	
	static WebDriver driver =  new FirefoxDriver();
	
	public static void TBEmpty() throws SecurityException, IOException, InterruptedException
	
	{
		String actual = null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);

		String msg;
		driver.get(DriverScript.GetParameterFromEnvironmentFile("Application_Link"));


		driver.manage().window().maximize();
	
	    LogRep.GenLogger("Browser has opened the window");
		
	    SCShot.captureScreenShots("Browser begins");
		//identify the edit box element using id
		//		WebElement e = driver.findElement(By.name("txtFirst"));
		//	    e.sendKeys("Sanket");
				
		
		        WebElement d = driver.findElement(By.name("txtLast"));
				//enter value in the editbox
				d.sendKeys(DriverScript.GetTestParameter("Last_name"));
				
				WebElement f = driver.findElement(By.name("txtLast"));
			    f.sendKeys(Keys.TAB,DriverScript.GetTestParameter("Address"));
			    
			    WebElement g = driver.findElement(By.name("txtPin"));
			    g.sendKeys(DriverScript.GetTestParameter("Pincode"));
			    
			    WebElement dropDownListBox = driver.findElement(By.name("selDest"));
			    Select clickThis = new Select(dropDownListBox);
			    clickThis.selectByValue("Pune");
			    
			    WebElement h = driver.findElement(By.name("txtToj"));
			    h.sendKeys(DriverScript.GetTestParameter("Time"));
			    
			    WebElement i = driver.findElement(By.name("txtDoj"));
			    i.sendKeys(DriverScript.GetTestParameter("Date"));
			    
			    WebElement j = driver.findElement(By.name("txtContact"));
			    j.sendKeys(DriverScript.GetTestParameter("Cellno"));
			    
			    WebElement k = driver.findElement(By.name("txtEmail"));
			    k.sendKeys(DriverScript.GetTestParameter("Mail"));
			    
			      SCShot.captureScreenShots("Form Values");
			      LogRep.GenLogger("All values have been entered into the Form");
			    
			    WebElement inputBox = driver.findElement(By.name("txtFirst"));
				String textInsideInputBox = inputBox.getAttribute("value");

				// Check whether input field is blank
				if(textInsideInputBox.isEmpty())
				{
					actual = "fail";
					
					msg = "The Textbox is empty";
				}
				else
				{
					actual = "pass";
				    msg = "The Textbox is not empty";
				} 
		        CreateReport.create( "Validate name textbox", "Textbox should be filled up", msg, actual, SCShot.captureScreenShots("Status"));
 
				
				
			    
			 /*   WebElement validate=driver.findElement(By.name("submit1"));
			    validate.click();
			    LogRep.GenLogger("Validating the Submit button");
			    SCShot.captureScreenShots("Submit button validation");
			  
			    
			    
			    driver.findElement(By.linkText("HOME")).click();
			    LogRep.GenLogger("Validating the HOME link");
			    SCShot.captureScreenShots("HOME page");
			    */
			    
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

				driver.close();
	
	
	}
}
