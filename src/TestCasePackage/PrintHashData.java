package TestCasePackage;
import MyPackage.*;
public class PrintHashData {
	public void test()
	{
		String value=DriverScript.GetTestParameter("A");
		System.out.println("Value:"+value);
		 value=DriverScript.GetTestParameter("B");
		System.out.println("Value:"+value);
		 value=DriverScript.GetTestParameter("C");
		System.out.println("Value:"+value);
		 value=DriverScript.GetTestParameter("D");
		System.out.println("Value:"+value); 
		value=DriverScript.GetTestParameter("E");
		System.out.println("Value:"+value);
	 value=DriverScript.GetTestParameter("F");
		System.out.println("Value:"+value);
		 value=DriverScript.GetTestParameter("G");
		System.out.println("Value:"+value);
		 value=DriverScript.GetTestParameter("H");
		System.out.println("Value:"+value);
	}

}
