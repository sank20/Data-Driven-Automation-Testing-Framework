package MyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.eclipse.jetty.websocket.WebSocket.Connection;

public class DatabaseConn {
	
	static Connection conn;
	static ResultSet rs;
	
	
	
	public static boolean Connect(String DatabasePath,String UserName,String Password) throws InstantiationException, IllegalAccessException 
	{
		try
		 {
	      
			     Class.forName("com.mysql.jdbc.Driver").newInstance();
			    		String path="jdbc:mysql://" + DatabasePath;
			    		System.out.println(path);
	             conn = DriverManager.getConnection("jdbc:mysql://localhost/taxi","root","");
			     System.out.println(DatabasePath+"    "+UserName+"       "+Password);
			      //conn = DriverManager.getConnection("jdbc:mysql://"+DatabasePath,UserName,Password);
                System.out.println("......................SUCCESSFULLY CONNECTED TO DATABASE "+path+"......................");
                
		 } catch(ClassNotFoundException | SQLException e){  System.out.println("Error Connecting to Database:"+ DatabasePath + e); return false;  }
		return true;
    }
	
	
	
	public static Object Execute(String Query) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try
		{
		 Statement stmt=conn.createStatement();
        
            rs= stmt.executeQuery(Query);
         /* while( rs.next())
          {
          String name= rs.getString("dest");               
           System.out.println(name);
          }
           //System.out.println("DOne..");*/
           return rs;
		}catch(SQLException e){  System.out.println("Error executing Query:"+e); return null; }
		
                
		

	}
	
	
	
	
	public static void  CloseConn() throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try
		{
			 conn.close();
			 System.out.println("...........................DATABASE CONNECTION IS CLOSED.........................." );
		}catch(SQLException e){  System.out.println("Error closing Connection:"+e); }
		
                
		

	}
	


		
	/*
	public static void main(String args[]) throws InstantiationException, IllegalAccessException 
	{      
		try
		 {
	      
			     Class.forName("com.mysql.jdbc.Driver").newInstance();
			     String psw="admin";
			     
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/taxi","root","");
                 System.out.println("success");
	                Statement stmt=con.createStatement();
	              // stmt.executeUpdate("Insert into student values(1,'abc','nagpur')");
	                ResultSet rs= stmt.executeQuery("Select dest from tdestination");
	               while( rs.next())
	               {
	               String name= rs.getString("dest");               
	                System.out.println(name);
	               }
	                System.out.println("DOne..");
	               //INSERT INTO `student`(`id`, `name`, `address`) VALUES (1,'amol','nagpur');
	            con.close();

	        }     catch(ClassNotFoundException | SQLException e){         System.out.println("error"+e);  }
	              }


*/
}
