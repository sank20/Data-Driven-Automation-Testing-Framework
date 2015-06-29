
import java.io.File;
import java.util.Date;
 
public class CreateDirectory
{
    public static void main(String[] args)
    {	
    	Date today= new Date();
    	String date= today.toString();
	File file = new File("C:\\Directory1");
	if (!file.exists()) {
		if (file.mkdir()) {
			System.out.println("Directory is created!");
		} else {
			System.out.println("Failed to create directory!");
		}
	}
 
	File files = new File("C:\\Directory2\\Sub2\\Sub-Sub2");
	if (files.exists()) {
		if (files.mkdirs()) {
			System.out.println("Multiple directories are created!");
		} else {
			System.out.println("Failed to create multiple directories!");
		}
	}
 
    }
}