package MyPackage;

	

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class SCShot {

	
	
	private static int delay=0;
	static String ScreenshotPath=null;
	 
	  public static  String captureScreenShots(String ScreenshotName) throws InterruptedException 
	    {
		  String DirectoryPath=Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
	    	//String dir1 = new File ("D:/Automation/Project/Report/Screenshot//").getAbsolutePath();
		String dir1 = new File (DirectoryPath+"/Screenshot//").getAbsolutePath();
	    	//String ScShot= dir1 ;
	    
	    	//File f1= new File(ScShot);
		File f1= new File(dir1);
	    	f1.mkdirs();
		Thread.currentThread().getId();
	    	Toolkit.getDefaultToolkit().getScreenSize();
	        
	        
	        
			try {
	          
		        Thread.sleep(10000);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	            	   
				Rectangle screenRectangle = new Rectangle(screenSize);
	            	  
				Robot robot = new Robot();
	            	 
				robot.delay(delay);
				
				BufferedImage image = robot.createScreenCapture(screenRectangle);
				
				robot.delay(delay);
			    
				//ImageIO.write(image, "jpg",new File("D:/Automation/Project/Report/SCReport/Screenshot\\"+getDateTime()+".jpg"));
				ImageIO.write(image, "jpg",new File(f1+"/"+ScreenshotName+".jpg"));
	                     // ScreenshotPath=DirectoryPath+"/Screenshot//"+ getDateTime()+".jpg";   
				           ScreenshotPath=DirectoryPath+"/Screenshot//"+ ScreenshotName+".jpg"; 
	                     System.out.println(ScreenshotPath);
		        
	                }  
			catch (IOException e) 
			{
	                    e.printStackTrace();
	                    //isSuccesful = false;
	                    return null;
	                }
	           
	        
catch (AWTException e1)
{
	            e1.printStackTrace();
	        
}
	      
//return isSuccesful;
			return ScreenshotPath;
	   
}
	    public static String getDateTime() 

		{

	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss"); 
	        return df.format(new Date()); 
	   
		} 

	

}









////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class SCShot {


	
	private static int delay=1;
    
 
  public static  boolean captureScreenShots() throws InterruptedException 
    {
    	String folderwithtime= getDateTime();
    	String dir1 = new File ("D:/Automation/Project/Report/SCReport/Screenshot").getAbsolutePath();
    	String ScShot= dir1 + folderwithtime;
    
    	
    	File f1= new File(ScShot);
    	f1.mkdirs();
    	
        boolean isSuccesful = false;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		try {
            Robot robot = new Robot();
            BufferedImage[] screenshots = new BufferedImage[20];
            Rectangle bounds = new Rectangle(0, 0, (int) size.getWidth(),(int) size.getHeight());
            for (int i = 1; i < screenshots.length; i++) 
            {
                System.out.println("Running");
                screenshots[i] = robot.createScreenCapture(bounds);
                robot.delay(delay);
                try {
                    ImageIO.write(screenshots[i], "jpeg", f1); 
                } catch (IOException e) {
                    e.printStackTrace();
                    isSuccesful = false;
                }
            }
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        return isSuccesful;
    }
    public static String getDateTime() 

	{

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss"); 
        return df.format(new Date()); 
   
	} 

}*/
	