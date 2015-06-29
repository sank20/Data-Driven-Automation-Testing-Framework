package MyPackage;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMsAccess {

	
	static Connection conn;
	static ResultSet rs;
	
		
	
	public static boolean Connect(String DatabasePath,String UserName,String Password) throws InstantiationException, IllegalAccessException 
	{
		
		 
        try
        {
            //System.out.println("filename");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String database = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ="+DatabasePath;
             conn = DriverManager.getConnection(database, UserName, Password);
            System.out.println("......................SUCCESSFULLY CONNECTED TO DATABASE "+database+"......................");
           
        } catch(ClassNotFoundException | SQLException e){  System.out.println("Error Connecting to Database:"+ DatabasePath + e); return false;  }
        return true;	
	}

	public static Object Execute(String Query) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try
		{
		 Statement stmt=conn.createStatement();
        
            rs= stmt.executeQuery(Query);
        
           
		}catch(SQLException e){  System.out.println("Error executing Query:"+e); return null; }
		
		return rs;      
		

	}
	
	
	
	
	public static void  CloseConn() throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try
		{
			 conn.close();
			 System.out.println("...........................DATABASE CONNECTION IS CLOSED.........................." );
		}catch(SQLException e){  System.out.println("Error closing Connection:"+e); }
		
	}      
		

	 
}