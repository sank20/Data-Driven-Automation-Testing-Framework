import java.io.IOException;


public class test {
public static void main(String args[]) throws IOException
{
	try{
	
	//CreateReport abc= new CreateReport();
	//abc.ResetReport();
	//CreateReport.ResetMainReport();
	CreateReport.create("example test step2", "this result is expected","this is the actual result","fail","/home/sanket/Downloads/10382418_10202433694616873_5647560010644397222_o.jpg");
	}
	catch(IOException e)
	{
		System.out.println("main madhla exception "+e);
	}
}
}
