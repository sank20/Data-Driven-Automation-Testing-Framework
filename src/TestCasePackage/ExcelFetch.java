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

public class ExcelFetch {

	public static void excelfetch() throws SecurityException, IOException, InterruptedException
	{
		
		WebDriver driver =  new FirefoxDriver();
		
		{
			
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);

			
		driver.get(DriverScript.GetParameterFromEnvironmentFile("Application_Link"));


		driver.manage().window().maximize();
		
		//identify the edit box element using id
				WebElement e = driver.findElement(By.name("txtFirst"));
				e.sendKeys(DriverScript.GetTestParameter("First_name"));
				
				
				 
		       CreateReport.create( "Enter in FirstName Text box", "should able to write in text box ", "entered first name", "pass", SCShot.captureScreenShots("FirstName"));
		       LogRep.GenLogger("FirstName is Entered");
		      
				
				
				WebElement d = driver.findElement(By.name("txtLast"));
				//enter value in the editbox
				d.sendKeys(DriverScript.GetTestParameter("Last_name"));
				
				
				
				 
			       CreateReport.create( "Enter in LastName Text box", "should able to write in text box ", "entered last name", "pass", SCShot.captureScreenShots("LastName"));
			       LogRep.GenLogger("LastName is Entered");
				
				
				WebElement f = driver.findElement(By.name("txtLast"));
			    f.sendKeys(Keys.TAB,DriverScript.GetTestParameter("Address"));
			    
			    CreateReport.create( "Enter in Address Text box", "should able to write in text box ", "entered address", "pass", SCShot.captureScreenShots("Address"));
			       LogRep.GenLogger("Address is Entered");
			    
			    
			    WebElement g = driver.findElement(By.name("txtPin"));
			    g.sendKeys(DriverScript.GetTestParameter("Pincode"));
			    
			   // CreateReport.create( "Enter in Pincode Text box", "should able to write in text box ", "entered Pincode", "pass", SCShot.captureScreenShots("Pincode"));
			       LogRep.GenLogger("Pincode is Entered");
			    
			    WebElement dropDownListBox = driver.findElement(By.name("selDest"));
			    Select clickThis = new Select(dropDownListBox);
			    clickThis.selectByValue("Pune");
			    
			    
			   // CreateReport.create( "Enter in Destination Text box", "should able to write in text box ", "entered Destination", "pass", SCShot.captureScreenShots("Destination"));
			       LogRep.GenLogger("Destination is Entered");
			    
			    WebElement h = driver.findElement(By.name("txtToj"));
			    h.sendKeys(DriverScript.GetTestParameter("Time"));
			    
			   // CreateReport.create( "Enter in Time Text box", "should able to write in text box ", "entered time", "pass", SCShot.captureScreenShots("Time"));
			       LogRep.GenLogger("Time is Entered");
			    
			    
			   
			    WebElement i = driver.findElement(By.name("txtDoj"));
			    i.sendKeys(DriverScript.GetTestParameter("Date"));
			    
			   // CreateReport.create( "Enter in Date Text box", "should able to write in text box ", "entered Date", "pass", SCShot.captureScreenShots("Date"));
			       LogRep.GenLogger("Date is Entered");
			    
			    WebElement j = driver.findElement(By.name("txtContact"));
			    j.sendKeys(DriverScript.GetTestParameter("Cellno"));
			    
			   // CreateReport.create( "Enter in ContactNumber Text box", "should able to write in text box ", "entered ContactNumber", "pass", SCShot.captureScreenShots("ContactNumber"));
			       LogRep.GenLogger("ContactNumber is Entered");
			    
			    WebElement k = driver.findElement(By.name("txtEmail"));
			    k.sendKeys(DriverScript.GetTestParameter("mail"));
			    
			   // CreateReport.create( "Enter in Emal Text box", "should able to write in text box ", "entered Email", "pass", SCShot.captureScreenShots("Email"));
			       LogRep.GenLogger("Email is Entered");
			  
			   // driver.wait(5);	    
			    WebElement validate=driver.findElement(By.name("submit1"));
			    validate.click();
			    
			   // CreateReport.create( "Click On Button", "should able to click on Button  ", "clicked on button", "pass", SCShot.captureScreenShots("SubmittButton"));
			       LogRep.GenLogger("Clicked on  Submit Button");
			    
			  
			    
			    
			    driver.findElement(By.linkText("HOME")).click();
			    
			   
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
				  // CreateReport.create( "Click on Home Link", "should able to redirect to home page ", "redirected to homepage", "pass", SCShot.captureScreenShots("HomePage"));
			       LogRep.GenLogger("clicked on home link");

				driver.close();
	    
		}
	}
}
