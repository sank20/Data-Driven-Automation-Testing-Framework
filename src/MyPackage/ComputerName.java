package MyPackage;
import java.net.InetAddress;
//import com.sun.security.auth.module.NTSystem.*;
public class ComputerName {
	public static void main(String args[])
	{
	//com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();
	//System.out.println(NTSystem.getName());
		String computerName,UserName;
		
		try {
		    computerName = InetAddress.getLocalHost().getHostName();
		    System.out.println("HostName of Local Machine: "+computerName);
		    UserName=System.getProperty("user.name"); 
		    System.out.println("User who is Currently Loged in: "+UserName);
		    //java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
		   // System.out.println("Hostname of local machine: " + localMachine.getHostName());
		}

		catch(Exception ex) {
		    
		}
	}
}
