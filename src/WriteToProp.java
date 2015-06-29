

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

//import jxl.write.biff.File;

//import jxl.write.biff.File;

public class WriteToProp {
	
	/*
	
	
	public static void main(String args[])
	{
	try {
		Properties properties = new Properties();
		properties.setProperty("favoriteAnimal", "marmot");
		properties.setProperty("favoriteContinent", "Antarctica");
		properties.setProperty("favoritePerson", "Nicole");

		File file = new File("D:/MainFolder/mainscript/backup/Training/WDDF/src/MyPackage/Param.properties");
		FileOutputStream fileOut = new FileOutputStream(file);
		properties.store(fileOut, "Favorite Things");
		fileOut.close();
	} catch (FileNotFoundException e) {e.printStackTrace();
	} catch (IOException e) {e.printStackTrace();
	}

}
        */
	
	
	
	 public void WritePropertiesFile(String key, String data) {
	        FileOutputStream fileOut = null;
	        FileInputStream fileIn = null;
	        try {
	            Properties configProperty = new Properties();

	            File file = new File("D:/backup/Training/WDDF/src/MyPackage/Param.properties");
	            fileIn = new FileInputStream(file);
	            configProperty.load(fileIn);
	            configProperty.setProperty(key, data);
	            fileOut = new FileOutputStream(file);
	            configProperty.store(fileOut, "sample properties");

	        } catch (Exception ex) {
	           
	        } finally {

	            try {
	                fileOut.close();
	            } catch (IOException ex) {
	               
	            }
	        }
	    }

	    public static void main(String[] args) {
	        WriteToProp help = new WriteToProp();
	        help.WritePropertiesFile("appwrite1", "write1");
	        help.WritePropertiesFile("appwrite2", "write2");
	        help.WritePropertiesFile("appwrite3", "write3");
	    }
	}




	