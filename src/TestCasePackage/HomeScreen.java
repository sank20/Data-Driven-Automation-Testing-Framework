package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import MyPackage.LogRep;
import MyPackage.SCShot;

public class HomeScreen {

	static WebDriver driver =  new FirefoxDriver();
	
	public static void HomeTest() throws InterruptedException, SecurityException, IOException
	{
		
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);

		
	driver.get("http://localhost/book.php");


	driver.manage().window().maximize();
	LogRep.GenLogger("Browser has opened the window");
	SCShot.captureScreenShots("Browser begins");
	//identify the edit box element using id
			WebElement e = driver.findElement(By.name("txtFirst"));
			e.sendKeys("Sanket");
			WebElement d = driver.findElement(By.name("txtLast"));
			//enter value in the editbox
			d.sendKeys("Pimple");
			WebElement f = driver.findElement(By.name("txtLast"));
		    f.sendKeys(Keys.TAB,"Vadgaon Budruk");
		    
		    WebElement g = driver.findElement(By.name("txtPin"));
		    g.sendKeys("411041");
		    
		    WebElement dropDownListBox = driver.findElement(By.name("selDest"));
		    Select clickThis = new Select(dropDownListBox);
		    clickThis.selectByValue("dhaisar");
		    
		    WebElement h = driver.findElement(By.name("txtToj"));
		    h.sendKeys("12::05::00");
		    
		    WebElement i = driver.findElement(By.name("txtDoj"));
		    i.sendKeys("29=05-2015");
		    
		    WebElement j = driver.findElement(By.name("txtContact"));
		    j.sendKeys("8055622666");
		    
		    WebElement k = driver.findElement(By.name("txtEmail"));
		    k.sendKeys("sanket.pimple@gmail.com");
		    
		    SCShot.captureScreenShots("Form Values");
		    LogRep.GenLogger("All values have been entered into the Form");
		    
		    WebElement validate=driver.findElement(By.name("submit1"));
		    validate.click();
		    LogRep.GenLogger("Validating the Submit button");
		    SCShot.captureScreenShots("Submit button validation");
		  
		    
		    
		    driver.findElement(By.linkText("HOME")).click();
		    LogRep.GenLogger("Validating the HOME link");
		    SCShot.captureScreenShots("HOME page");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

			driver.close();
    
	}
	
	
}
