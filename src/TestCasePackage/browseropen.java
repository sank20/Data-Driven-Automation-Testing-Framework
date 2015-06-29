package TestCasePackage;

// import java.util.concurrent.TimeUnit;

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

public class browseropen
{ 
 //To open Firefox browser
 WebDriver driver = new FirefoxDriver();
 
 
 public void test() throws SecurityException, IOException, InterruptedException {

 //To Maximize Browser Window
  driver.manage().window().maximize();
  LogRep.GenLogger("The window has been maximised");

 //To Open URL In browser
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  LogRep.GenLogger("The Browser has been opened");
  SCShot.captureScreenShots("Firefox1");
 
 }
 
}
 
 
 
 