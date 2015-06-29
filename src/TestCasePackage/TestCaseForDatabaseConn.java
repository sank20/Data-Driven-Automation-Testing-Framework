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
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opera.core.systems.scope.protos.EcmascriptProtos.Object;

import MyPackage.*;

public class TestCaseForDatabaseConn {
	
	
	
	
	

		public  void test() throws InterruptedException, SecurityException, UnknownHostException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
			{
			
			ResultSet rs=null;
					
					
					
				
					boolean flag1=DatabaseConn.Connect("localhost:/taxi", "root", "");
					
					
					
					if(flag1==true)
					{System.out.println("return true value  ");
						rs= (ResultSet) DatabaseConn.Execute("Select dest from destination");
						
					}
					
					
					
					if(rs!=null)
					{
						while( rs.next())
			               {
			               
							String name= rs.getString("dest");
			                System.out.println("                         "+name);
			               }
					}
					DatabaseConn.CloseConn();
					
			}
		
	}







