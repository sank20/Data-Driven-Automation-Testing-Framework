package TestCasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Used Inheritance
public class Common_Functions_Test extends CommonFunctions{
WebDriver driver; 

 public void test() {
  driver = new FirefoxDriver();
  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
  test1();
  test2();
 }
 

 public void test2() {  
  driver.quit();  
 }
 

 public void test1(){  
  String actualTitle = driver.getTitle();
  //Call compareStrings method Inside If condition to check string match or not.
  if(compareStrings(actualTitle, "Only Testing: LogIn")){
   //If strings match, This block will be executed.
   System.out.println("Write Action taking lines In this block when title match.");
  }else{
   //If strings not match, This block will be executed.
   System.out.println("Write Action taking lines In this block when title not match.");
  }   
  //To mark test fail In report at the end of execution If strings not match.
  Soft_Assert.assertAll();
 } 
}