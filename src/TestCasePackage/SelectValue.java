package TestCasePackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import MyPackage.LogRep;
import MyPackage.SCShot;

public class SelectValue 
{
 WebDriver driver = new FirefoxDriver();
 
 
 public void beforetest() throws InterruptedException, SecurityException, IOException {
  driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
  SCShot.captureScreenShots("browser open");
  test();
  aftertest();
 }
 
 
 public void aftertest() {
  driver.quit();
  
 }
 

 public void test () throws InterruptedException, SecurityException, IOException 
 {  
  driver.findElement(By.id("text1")).sendKeys("My First Name");

  //Selecting value from drop down using visible text
  Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
  mydrpdwn.selectByVisibleText("Audi");
  WebDriverWait wait = new WebDriverWait(driver, 15);
  LogRep.GenLogger("element selection from dropdown");
  SCShot.captureScreenShots("element selected");
  wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
  SCShot.captureScreenShots("Result");
 }
   
}