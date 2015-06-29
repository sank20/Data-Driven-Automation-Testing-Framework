package MyPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
////
//import java.io.File;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import MyPackage.*;


public class DriverScript 
{
	
	static Map<String, String> EnvironmentFileHash = new HashMap<String, String>();
	static Map<String, String> TestDataHash = new HashMap<String, String>();
	
	
	
   public static String GetParameterFromEnvironmentFile(String Param)
   {
			 System.out.println("param from user:"+ Param);
			 String Value=EnvironmentFileHash.get(Param);
			 return Value;
				
   }
	 
	 
   public static String GetTestParameter(String Param)
   {
	   		System.out.println("Test param from user:"+ Param);
	   		String Value=TestDataHash.get(Param);
	   		return Value;
				
   }
	 
	 /*public void runTest(String testClass, String testcaseName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		 Object carObj = Class.forName(testClass).newInstance();
		// carObj.testcaseName();
		 
			
			//MyClass c = new MyClass();
			Class classObj = carObj.getClass();
			Method gs1Method = classObj.getMethod(testcaseName, new Class[] {});
			String str1 = (String) gs1Method.invoke(carObj, new Object[] {});
		}*/
   
   
	 public void runTest(String testClass, String testcaseName)
	 {
		 		try {
		 				ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
	            
		 				String classNameToBeLoaded = "TestCasePackage."+testClass;
	            
		 				Class myClass = myClassLoader.loadClass(classNameToBeLoaded);
	            
	            
		 				Object whatInstance = myClass.newInstance();
	            
	            
		 				Method myMethod = myClass.getMethod(testcaseName,new Class[] { });
	            
	            
	            
		 				myMethod.invoke(whatInstance, new Object[] { });
	            
	            
		 			} catch (SecurityException e) {  e.printStackTrace(); } 
		 			  catch (IllegalArgumentException e) {  e.printStackTrace(); } 
		 			  catch (ClassNotFoundException e) { e.printStackTrace(); } 
		 			  catch (InstantiationException e) { e.printStackTrace(); } 
		 			  catch (IllegalAccessException e) { e.printStackTrace(); }
		 		      catch (NoSuchMethodException e) { e.printStackTrace(); } 
		 		      catch (InvocationTargetException e) { e.printStackTrace();}
	    
	 }
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 public static void main(String[] args) 
			 throws IOException,
			 		InstantiationException,
			 		IllegalAccessException, 
			 		ClassNotFoundException, 
			 		NoSuchMethodException,
			 		SecurityException, 
			 		IllegalArgumentException, 
			 		InvocationTargetException,
			 		InterruptedException 
			
			 			{
		 
		 
		     				Fetch_Param FetchParam= new Fetch_Param(); 
		     				long TotalExecutionTime=0;
		     				//String ReleaseValue=Fetch_Param.Fetch_Param_From_Properties("ReleaseVersion");
		     				String ReleaseValue=Fetch_Version_Package.Fetch_Param_From_Properties("ReleaseVersion");
	                     
		     				if(ReleaseValue==null)
		     				{
		     					System.out.println("****************ERROR!*******************");
		     					System.out.println("******PLEASE SET THE VALUE OF RELEASE VERSION IN PARAM.PROPERTIES FILE*********");
		     					System.out.println("**********EXECUTION TERMINATED!*************");
		     					return;
		     				}
		     				  
	         
	         
		     				System.out.println("                             TESTING :-" + ReleaseValue+ " Of Web Application");
	         
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	      
		     				
		     				// Map<String, String> EnvironmentFileHash = new HashMap<String, String>();
		     				
		     				
		     				FileInputStream fis = new FileInputStream(new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Environment/EnvironmentFile.xlsx"));
		     				XSSFWorkbook workbook = new XSSFWorkbook (fis);
		     				XSSFSheet sheet = workbook.getSheetAt(0);
			
		     				Iterator ite = sheet.rowIterator();
		     				Iterator ite1 = sheet.rowIterator();
			
		     				Row row,row1,row2,FirstRow;
		     				
		     				Cell cell_Variable,cell_Value,Hash_Key,Hash_Value;
		     				
		     				String CellValue=null;
		     				String Variable_Name=null, Variable_Value=null;
			
			
		     				DriverScript DriverScriptObj=new DriverScript();
			
			                boolean VersionFound=false;
		     				for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex=rowIndex + 1)
		     				{
		     					
		     					row1 = sheet.getRow(rowIndex);
		     					FirstRow=sheet.getRow(0);
				  
				  					if (row1 != null)
				  					{
				  						int Column_Count=row1.getPhysicalNumberOfCells();
				  						////System.out.println("column count of this row:- " + Column_Count);
				  						
				  								 		
				  						 int colIndex=0;
				  							  					
   				  						 cell_Variable = row1.getCell(colIndex);
				  							
				  							
				  								if (cell_Variable != null) 
				  								{
				  											
				  										CellValue = cell_Variable.getStringCellValue();
				  										
				  										////System.out.println(CellValue);
				  										
				  										  if(CellValue.equals(ReleaseValue))
				  										       //if((new String(CellValue) == new String(ReleaseValue)))
				  										  {
				  										    	 ////System.out.println("Found in this column:-" + CellValue);
				  										    	 
				  										    	System.out.println( );
				  										    	
				  										    	System.out.println("                   FETCHING PARAMETERS  FROM ROW="+rowIndex+ "OF ENVIRONMENTAL FILE.");
				  										    	
				  										    	 //colIndex=1;
				  										    	System.out.println("            **********FOLLOWING KEY-VALUE PAIRS INSERTING INTO HASH TABLE********");
				  										    	
				  										    	System.out.println( ); 		
				  										    	
				  										    	
				  										    	
				  										    		for ( colIndex = 1; colIndex < Column_Count; colIndex=colIndex + 1)
				  										    	 	{
				  										    			
				  										    	 			Hash_Key=FirstRow.getCell(colIndex);
				  										    	 			
				  										    	 			Hash_Value=row1.getCell(colIndex);
				  										    	 			
				  										    	 			Hash_Key.setCellType(Hash_Key.CELL_TYPE_STRING);
				  										    	 			
				  										    	 			Hash_Value.setCellType(Hash_Value.CELL_TYPE_STRING);
				  										    	 			
				  										    	 			Variable_Name=Hash_Key.getStringCellValue();
				  										    	 			
				  										    	 			Variable_Value=Hash_Value.getStringCellValue();
				  										    	 			 										    	 			
				  										    	 			  								    	 							  										    	 			
				  										    	 			EnvironmentFileHash.put(Variable_Name, Variable_Value);
				  										    	 			
				  										    	 			System.out.println("                                "+Variable_Name +":" + Variable_Value);
				  										    	 			
				  										    	 	 }//end of for loop
				  										    	 
				  										    		VersionFound=true;
				  										    	 
				  										    	 break;
				  										       }//end of if
				  										  
				  										  
				  										        
				  										  
				  										  
				  										  
				        
				  									}//end of if
				  								
				  										
				    
				  						}//end of if in for
				  					
				            }//end of for loop for row
		     				
		     				if(VersionFound=false)
		     				{
		     					
							        
							        	

				     					System.out.println("****************ERROR!*******************");
				     					System.out.println("******PLEASE SET THE VALUE OF ReleaseVersion IN Release column of Environment.xls FILE*********");
				     					System.out.println("**********EXECUTION TERMINATED!*************");
				     					return;
							        	
				     					
							        
		     					
		     				}
					
					fis.close();
					 
					
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
					//String HashParameterValue=EnvironmentFileHash.get("DB1");
					//System.out.println("value from Environment Hash table:" +HashParameterValue );
					//String HashParameterValue=DriverScriptObj.GetParameterFromEnvironmentFile("DB1");
					////System.out.println("Value by Function:" +GetParameterFromEnvironmentFile("Application_Link") );
					
					
					
					
					
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					//code to delete all files from execution folder
					
					
					
							File fin = new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/");
							
							File[] finlist = fin.listFiles();   
							
							for (int n = 0; n < finlist.length; n++) 
							{
								if (finlist[n].isFile())
								{
									System.gc();
									Thread.sleep(2000);
									finlist[n].delete();
								}
							}        
					
					
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					
					//code to copy Package from Package folder to execution folder
					
							//String PackageName=FetchParam.Fetch_Param_From_Properties("PackageName");
							String PackageName=Fetch_Version_Package.Fetch_Param_From_Properties("PackageName");
							System.out.println("                    **********PACKAGE " +PackageName+ " SELECTED FOR EXECUTION.**********");
							
							if(PackageName==null)
		     				{
		     					System.out.println("****************ERROR!*******************");
		     					System.out.println("******PLEASE SET THE VALUE OF PackageName IN PARAM.PROPERTIES FILE*********");
		     					System.out.println("**********EXECUTION TERMINATED!*************");
		     					return;
		     				}
							
							File source = new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Template/Package/"+ PackageName);
							
							File dest = new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/");
							
							try 
							{
								FileUtils.copyDirectory(source, dest);
								
							} catch (IOException e) {e.printStackTrace();}
					
					
					
							String PackagePath="D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/"+ PackageName +".xlsx";
					
							//String PackagePath="D:/Automation/Project/Template/Package/"+ PackageName +".xlsx";
					
							
							
							
							 DateFormat df = new SimpleDateFormat("dd-MM-yy");
		  					 DateFormat df1 = new SimpleDateFormat("hh-mm-ss");

		  					
		  					Date today = Calendar.getInstance().getTime();        
		  					
		  					String reportDate = df.format(today);
		  					String reportDate1 = df1.format(today);
		  					
		  					System.out.println("Report Date: " +reportDate+reportDate1);
		  					
		  					
					
				/////////////////////////////////////////////////////////////////////////////////////////////////////
					
										                 
						                  
						               	
						     FileInputStream fisTestCase = new FileInputStream(new File(PackagePath));
						     
						     XSSFWorkbook workbookTestCase = new XSSFWorkbook (fisTestCase);
						     
						     XSSFSheet sheetTestCase = workbookTestCase.getSheetAt(0);
						     
						     Iterator iteTestCase = sheetTestCase.rowIterator();
						           		
						     //System.out.println("fetch from next Excel");
						           		
						           		/////////////////////////////////////////////////////////////////////////////////////////////////
						     
						           		Row TestCaseRow,HashValueRow;
						           		
						           		Cell cell_ClassName,cell_MethodName;
						           		
						           		String ClassName=null,MethodName=null;
						           		
						           		Cell TestData_Hash_Key,TestData_Hash_Value;
						           		
						           		String TestData_Variable_Name=null,TestData_Variable_Value=null;
						           		
						           		
						           		
						           		int LastRow=sheetTestCase.getLastRowNum();
						           		System.out.println("total rows in sheet"+LastRow);
						           		
						           		FileOutputStream fileOut = new FileOutputStream("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/"+ PackageName +".xlsx");
						           		
						           		
						           		for (int rowIndex = 1; rowIndex <= sheetTestCase.getLastRowNum(); rowIndex=rowIndex + 2)
						        		{
						           			
						           			
						        			  TestCaseRow = sheetTestCase.getRow(rowIndex);
						        			  HashValueRow=sheetTestCase.getRow(rowIndex + 1);
						        			  
						        			  TestDataHash.clear();
						        			  
						        			  		if (TestCaseRow != null & HashValueRow!=null) 
						        			  		{
						        			  			
						        			  		     Cell TestToRun=HashValueRow.getCell(3);
						        			  			 String TestCaseToRun=TestToRun.getStringCellValue();
						        			  					////System.out.println("above in inner if ");
						        			  			 
						        			  				if(TestCaseToRun.equals("y") | TestCaseToRun.equals("Y"))
							        			  			{  
						        			  					////System.out.println("Entered in inner if ");
						        			  					System.out.println("                     *********FETCHING ROW=" +rowIndex +" FROM " +PackageName +" EXCEL");
						        			  					
						        			  					int colIndex=4;
						        			  									        			  						
						        			  					//cell_ClassName = TestCaseRow.getCell(colIndex);
						        			  					cell_ClassName = HashValueRow.getCell(colIndex);
						        			  					colIndex=5;
						        			  					//cell_MethodName = TestCaseRow.getCell(colIndex);
						        			  					cell_MethodName = HashValueRow.getCell(colIndex);
						        			  							
						        			  							
						        			  								if (cell_ClassName != null) 
						        			  								{
						        			  									ClassName = cell_ClassName.getStringCellValue();
						        			  									System.out.println("                     ClassName from Excel: "+ClassName);
						        			  								}
						        			  								
						        			  								if (cell_MethodName != null) 
						        			  								{
						        			  											
						        			  									MethodName = cell_MethodName.getStringCellValue();
						        			  									System.out.println("                     MethodName from Excel: "+MethodName);
						        			  								}
						        			  									
						        			  					////////////////////////////////////////////////////////
						        			  					//code to put test data in TestDataHash
						        			  								
						        			  					int testDataColumnCount=HashValueRow.getPhysicalNumberOfCells();
						        			  					
						        			  										System.out.println("columncount:"+ testDataColumnCount );
						        			  										
						        			  					/////////////////////////////////////////////////////////////////////////////////////////////////
						        			  					
						        			  					int ColumnCount=6;
						        			  					
						        			  					Cell CellCount;
						        			  					
						        			  					while((CellCount=TestCaseRow.getCell(ColumnCount))!=null)
						        			  					{
						        			  						ColumnCount=ColumnCount+1;
						        			  					}
						        			  										
						        			  					////////////////////////////////////////////////////////////////////////////////////////////////	
						        			  					
						        			  					System.out.println("             *************FOLLOWING KEY-VALUE PAIRS INSERTING INTO HASH TABLE**************");	
						        			  					
						        			  					System.out.println( );	
						        			  					System.out.println( "column count:"+ ColumnCount);	
						        			  					
						        			  					if(testDataColumnCount > 5)
						        			  					{
						        			  						
						        			  					
						        			  					for (int TestDatacolIndex = 6; TestDatacolIndex < ColumnCount; TestDatacolIndex=TestDatacolIndex + 1)
						        								{
						        			  						
						        			  						TestData_Hash_Key=TestCaseRow.getCell(TestDatacolIndex);
		  										    	 			TestData_Hash_Value=HashValueRow.getCell(TestDatacolIndex);
		  										    	 			TestData_Hash_Key.setCellType(TestData_Hash_Key.CELL_TYPE_STRING);
		  										    	 			TestData_Hash_Value.setCellType(TestData_Hash_Value.CELL_TYPE_STRING);
		  										    	 			
		  										    	 			TestData_Variable_Name=TestData_Hash_Key.getStringCellValue();
		  										    	 			
		  										    	 			TestData_Variable_Value=TestData_Hash_Value.getStringCellValue();
		  										    	 			
		  										    	 			
		  										    	 			 										    	 			
		  										    	 			
		  										    	 			TestDataHash.put(TestData_Variable_Name, TestData_Variable_Value);
		  										    	 			System.out.println("                        "+TestData_Variable_Name +" : " +TestData_Variable_Value );
						        			  						
						        								}
						        			  						
						        			  					}
						        			  					///////////////////////////////////////////////////////		
						        			  					
						        			  					System.out.println( );		
						        			  					System.out.println("        *************INVOKING METHOD: "+MethodName+" OF CLASS : "+ClassName );				
						        			  					
						        			  					
						        			  					//////////////////////////////////////////////////////////////////////////
						        			  					//create directory
						        			  					
						        			  					
						        			  					TestData_Hash_Value=HashValueRow.getCell(2);
	  										    	 			TestData_Hash_Value.setCellType(TestData_Hash_Value.CELL_TYPE_STRING);
	  										    	 			String TestCaseName=TestData_Hash_Value.getStringCellValue();
	  										    	 			WriteToProp help = new WriteToProp();
	  										    	 			help.WritePropertiesFile("testcasename", TestCaseName);
						        			  					
						        			  					
						        			  					String ParamPath="D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Report/"+ReleaseValue+"/"+PackageName+"/"+reportDate+"/"+reportDate1+"/"+TestCaseName+"/";
						        			  					
						        			  					
						        			  					help.WritePropertiesFile("DirectoryPath", ParamPath);
						        			  					
						        			  					File f1=new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Report/"+ReleaseValue+"/"+PackageName+"/"+reportDate+"/"+reportDate1+"/"+TestCaseName+"/");
						        			  					//File f1=new File("D:/aaa/"+reportDate);
						        			  					f1.mkdirs();
						        			  					//System.out.println("folder created");
						        			  					
						        			  					
						        			  					
						        			  					
						        			  					
						        			  					//////////////////////////////////////////////////////////////////////////////
						        			  					
						        			  					long startTime = System.currentTimeMillis();
						        			  					
						        			  					
						        			  			 		
						        			  			 		//duration = duration/1000;	
						        			  			        
						        			  					
						        			  					DriverScriptObj.runTest(ClassName, MethodName);
						        			  					
						        			  					
						        			  					long endtime= System.currentTimeMillis();
						        			  			 		long duration = (endtime - startTime);
						        			  			 		TotalExecutionTime= TotalExecutionTime + duration;
						        			  			 		String time=""+duration/1000;
						        			  			 		help.WritePropertiesFile("TestExecutionTime",time);
						        			  			 		System.out.println("the time taken for executing the the abv statements is     " + duration/1000 );
						        			  			 		
						        			  					
						        			  					System.out.println( );
						        			  					
						        			  					
						        			  					///////////code to update Excel after test execution
						        			  					
						        			  					 //Cell StatusCell=HashValueRow.getCell(1);
						        			  					// StatusCell.setCellValue("PASS");
						        			  					//Iterator iterator = sheetTestCase .rowIterator();
						        			  					// if(iterator.hasNext()){
						        			  					        Row myRow= sheetTestCase.getRow(rowIndex + 1);
						        			  					        //Cell myCell = myRow.getCell(1);
						        			  					      //myCell.setCellType(myCell.CELL_TYPE_STRING);
						        			  					      //myCell.setCellValue("PASS");
						        			  					      
						        			  					    Cell cell = myRow.createCell(1);
						        			  					   String Status =Fetch_Param.Fetch_Param_From_Properties("Status");
						        			  				        cell.setCellValue(Status);
						        			  				      //FileOutputStream fileOut = new FileOutputStream("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/"+ PackageName +".xlsx");
						        			  			        //workbookTestCase.write(fileOut);  
						        			  			       // fileOut.close();
						        			  			     // workbookTestCase = new XSSFWorkbook(new FileInputStream("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/"+ PackageName +".xlsx"));
						        			  					    //}
						        			  				        
						        			  				        
						        			  				        
						        			  				        //////////////////////////////////////////
						        			  			/*	        
						        			  				      FileWriter main1=null;
						        			  					///try{
						        			  						
						        			  					String Test = Fetch_Param.Fetch_Param_From_Properties("TestName");
						        			  					String time1=Fetch_Param.Fetch_Param_From_Properties("TestExecutionTime");
						        			  					String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
						        			  					File MainReport= new File(MainPath);
						        			  					
						        			  					Document mainrep=Jsoup.parse(MainReport, "UTF-8");
						        			  					mainrep.select("h2").last().after("<br><h2>Execution Time:"+time1+"</h2>");
						        			  					main1 = new FileWriter(MainReport.getParentFile()+File.separator+Test+".html");
						        			  					main1.write(mainrep.toString());
						        			  					
						        			  					//}
						        			  					//catch(IOException e){
						        			  					//	System.out.println(e);
						        			  					//}
						        			  					//finally{
						        			  					//	main1.close();
						        			  					//}
						        			  				        
						        			  				      */  
						        			  				        
						        			  				        
						        			  				        
						        			  				        
							        			  				      FileWriter main1=null;
								        			  					///try{
								        			  						
								        			  					String Test = Fetch_Param.Fetch_Param_From_Properties("testcasename");
								        			  					String time1=Fetch_Param.Fetch_Param_From_Properties("TestExecutionTime");
								        			  					String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
								        			  					File MainReport= new File(MainPath+File.separator+Test+"_report.html");
								        			  					//File MainReport= MainReport1.getParentFile();
								        			  			
								        			  					BufferedWriter w1=null;
								        			  					
								        			  					Document rep=Jsoup.parse(MainReport, "UTF-8");
								        			  					
								        			  					rep.select("h2").last().after("<br><h2>Execution Time:"+time1+" seconds"+"</h2>");
								        			  					//mainrep.getElementById("extime").text(time1+" seconds");
								        			  					w1=new BufferedWriter(new FileWriter(MainReport));
								        			  					w1.write(rep.toString());
								        			  					//main1 = new FileWriter(MainReport.getParentFile()+File.separator+Test+".html");
								        			  					//main1.write(mainrep.toString());
								        			  					
								        			  					//}
								        			  					//catch(IOException e){
								        			  					//	System.out.println(e);
								        			  					//}
								        			  					//finally{
								        			  					//	main1.close();
								        			  					//}
								        			  				        w1.close(); 

						        			  				        ///////////////////////////////////////////////
						        			  				        
						        			  								
						        			  			}//end of inner if
						        		}//end first if
						        		
						        		
						        	}//end for loop
						           		workbookTestCase.write(fileOut);  
	        			  			        fileOut.close();
						           		fisTestCase.close();
						           		
						           		////////////////////////////////////////////////////////////////////////////////////////////
						           		//code to update total execution time in Main Report
						           		String TotalExecutionTime1=""+TotalExecutionTime/1000;
						           		WriteToProp obj=new WriteToProp();
						           		obj.WritePropertiesFile("TotalExecutionTime",TotalExecutionTime1);
						           		
						           		
						           		///////////////////////////////////////////////////////////////////////////////////////////////
						           		//code to update main html report
						           		String path= Fetch_Param.Fetch_Param_From_Properties("ParentPath");
						           		String Test1 = Fetch_Param.Fetch_Param_From_Properties("TestName");
						           		String totaltime=Fetch_Param.Fetch_Param_From_Properties("TotalExecutionTime");
						           		File f= new File(path+File.separator+Test1+".html");
						           		Document mainrep= Jsoup.parse(f,"UTF-8");
						           		mainrep.getElementById("totaltime").text("Total Execution Time :"+totaltime+"seconds");
						           		BufferedWriter wr= new BufferedWriter(new FileWriter(f));
						           		wr.write(mainrep.toString());
						           		wr.close();
						           		//////////////////////////////////////////////////////////////////////////////////////////////
						           		//code to send email
						           		
						           		String EmailId=Fetch_Version_Package.Fetch_Param_From_Properties("EmailId");
						           		String MainPath = Fetch_Param.Fetch_Param_From_Properties("DirectoryPath");
        			  					String Test = Fetch_Param.Fetch_Param_From_Properties("TestName");

						           		File mailFile= new File(MainPath);
						           		String attachment= mailFile.getParent()+File.separator+Test+".html";
						           		
						           		SendEmail.SendMainReport(EmailId,attachment);
						           		///////////////////////////////////////////////////////////////////////////////////////////////////
						           		   						/*while(iteTestCase.hasNext())
						           		   						{
						           		   							
						           		   								Row row1 =(Row) ite1.next();
						           		   								Iterator<Cell> cite1 = row1.cellIterator();
						           		
						           		   								while(cite1.hasNext())
						           		   								{
						           		   									Cell c1 = cite1.next();
						           		   							 	
						           		   							
						           		   								String classname = new String(c1.getStringCellValue());
						           		   							c1 = cite1.next();
						           		   							String testname = new String(c1.getStringCellValue());
						           		   							obj.runTest(classname, testname);
						           		   						
						           		   									System.out.print(c1.toString() +"  ");
						           			
						           			
						           		   								}
						           		   									System.out.println();
						           		   									
						           		   						}
						           		   					fisTestCase.close();

						                             }
					                     
					                            }
					

					
					                                         */
					
					///////////////////////////////////////////////////////////////////////////////////////////////////
					
					
								// code to copy package after execution to report
				
					
					
						           		 source = new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Execution/");
										
										 dest = new File("D:/Automation/Project/Data_Driven_Automation_Testing_Framework/Project/Report/"+ ReleaseValue+ "/"+ PackageName+ "/" + reportDate+ "/"+reportDate1 +"/");
										
										try 
										{
											FileUtils.copyDirectory(source, dest);
											
										} catch (IOException e) {e.printStackTrace();}
								
					
					
					
					
					
					
					
					
					
			
			}//end of main method
			
			
		
	}//end of class

