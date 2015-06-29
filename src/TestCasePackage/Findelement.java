package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import MyPackage.LogRep;
import MyPackage.SCShot;

public class Findelement { 
 //To open Firefox browser
	 WebDriver driver = new FirefoxDriver();
 
 
 public void beforetest() throws SecurityException, IOException, InterruptedException {
	
 //To Maximize Browser Window
  driver.manage().window().maximize();
  LogRep.GenLogger("Window Maximised");

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  LogRep.GenLogger("Browser Opened in URL");
  SCShot.captureScreenShots("OpenedBrowser");
  driver.quit();
 test();
 aftertest();
 }
 
 public void test() throws SecurityException, IOException, InterruptedException 
 {
	 
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  //Locating element by tagName and store its text in to variable dropdown.
	   String dropdown = driver.findElement(By.tagName("select")).getText();
	   LogRep.GenLogger("Located element by tag name and store its text into variable dropdown");
	   System.out.print("Drop down list values are as bellow :\n"+dropdown);
	   SCShot.captureScreenShots("SC1");
 }

 

 public void aftertest() 
 {
  driver.quit();
  
 }
 

 
 }

