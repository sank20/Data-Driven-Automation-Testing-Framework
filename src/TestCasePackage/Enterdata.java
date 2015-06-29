package TestCasePackage;

import java.util.concurrent.TimeUnit;

import org.apache.xalan.trace.SelectionEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Enterdata {

	
	
	public static void test1()
	{
		
		

		
		WebDriver driver =  new FirefoxDriver();


		try{

		 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(75,TimeUnit.SECONDS);

		//navigate to given url
		driver.get("http://localhost/book.php");

		//Maximize the browser window
		driver.manage().window().maximize();

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
	    
	
	    
	   // WebDriver driver1=new FirefoxDriver();
        //driver1.get("http://localhost/book.php");

        WebElement validate=driver.findElement(By.name("submit1"));
        validate.click();
        
		Thread.sleep(2000);
		driver.close();
		}

		catch(Exception e){
		 System.out.println("Exception - > " + e.toString());
		 }
		 finally{
		  driver.close();
		  driver.quit();
		 }
		} //main function ends
	
}
