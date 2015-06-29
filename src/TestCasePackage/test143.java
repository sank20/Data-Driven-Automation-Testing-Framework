package TestCasePackage;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opera.core.systems.scope.protos.EcmascriptProtos.Object;

import MyPackage.*;

public class test143 {
public void test() throws SecurityException, IOException, InterruptedException
{
	WebDriver driver = new FirefoxDriver();
	Fetch_Param FetchParam= new Fetch_Param();
	LogRep.GenLogger("start of test case one");
	 driver.manage().window().maximize();
	 // driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
	 driver.get(" http://localhost/book.php");
    // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     CreateReport.create( "open book.php", "expected", "actual", "pass", SCShot.captureScreenShots("BookPage"));
	  LogRep.GenLogger("The Browser has been opened");
	 

     //driver.findElement(By.id("f3")).click();
    /// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //flag =SCShot.captureScreenShots();
     driver.quit();
}
}