package TestCasePackage;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CommonFunctions {
 
 SoftAssert Soft_Assert = new SoftAssert();
 
 public boolean compareStrings(String actualStr, String expectedStr){
  try{
   //If this assertion will fail, It will throw exception and catch block will be executed.
   Assert.assertEquals(actualStr, expectedStr);
   }catch(Throwable t){
    //This will throw soft assertion to keep continue your execution even assertion failure.
    //Use here hard assertion "Assert.fail("Failure Message String")" If you wants to stop your test on assertion failure.
    Soft_Assert.fail("Actual String '"+actualStr+"' And Expected String '"+expectedStr +"' Do Not Match.");
    //If Strings will not match, return false.
    return false;
   }
  //If Strings match, return true.
  return true;
 } 
}