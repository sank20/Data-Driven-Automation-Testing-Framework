package MyPackage;



import java.io.File;
import java.net.InetAddress;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
public class LogRep {

   
	public static Logger logger = Logger.getLogger(LogRep.class.getName());
	


	

	public static void GenLogger(String msg) throws SecurityException, IOException {
		// TODO Auto-generated method stub

		  String CN = InetAddress.getLocalHost().getHostName();
		  String UN=System.getProperty("user.name");
		  
		  String DirectoryPath=Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
	
      
      
     // try {
      	  
		  String dir1 = new File (DirectoryPath+"/Logger//").getAbsolutePath();
	    	//String ScShot= dir1 ;
	    
	    	//File f1= new File(ScShot);
		File f1= new File(dir1);
	    	f1.mkdirs();
		  
		  
      	
      	
      //	File file = new File(DirectoryPath+"/"+"LogReport//");
      //	file.getParentFile().mkdirs();
   
          FileHandler fh = new FileHandler(f1+"/"+"MyLogFile.log");
          logger.addHandler(fh);
          SimpleFormatter formatter = new SimpleFormatter();  
          fh.setFormatter(formatter);    
		    logger.setLevel(Level.FINE);

          logger.log(Level.INFO, msg);
      	logger.config("COMPUTER NAME :"+ CN + "  " + "USER NAME:"+ UN);  

          
       //   }
	
		
	     }

    


}
    




