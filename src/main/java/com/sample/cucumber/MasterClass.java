package com.sample.cucumber;

import java.text.SimpleDateFormat;
import java.util.Properties;

import com.sample.cucumber.reportInitializer.FrameworkReportInitializer;
import com.sample.utilities.FileUtils;
import com.sample.utilities.PropertyFileInitializer;
import com.sample.utilities.RestAssuredUtils;
import org.testng.Reporter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Subodh Kumar
 *
 */

public class MasterClass extends FrameworkReportInitializer {
	
	//TimeStamp Initialization
	public static String gstrTimeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new java.util.Date());
			
	//Variable declaration's
	public static String gstrReporterType;
	public static String gstrFramework_Path;
	public String strGlobalPropertyFile_Path;
					
	//Flags
	public static boolean gblnProxySetupFlag;
				
	//Object reference declaration's 
	public static Properties grefGlobalProperties;
	public static RequestSpecification gRequest;
	public static Response gResponse;
	public String ntgVersion;
	public String jobType;
	public String jobSource;
	
		
	/* ************************************************* 
	Function Name : classObject_Initialization 
	Description : This function is used to initialize class objects
	Input parameters : ReporterUtility refReporterUtility
	ReturnType : String (Type of Report)
	************************************************* */
	public void classObjectInitialization() throws Exception {
		try{
			Reporter.log("GlobalInitialization: Class objects created");
		}catch (Exception e) {
			Reporter.log("ERROR: Exception at globalInitialization: classObject_Initialization", true);
			Reporter.log("ERROR: StackTrace: "+e.toString());	
				throw e;
		}			
	}
		
	/* ************************************************* 
	Function Name : frameworkAndPropertyfilePath_Initialization 
	Description : This function is used to initialize framework and propertyfile path
	Input parameters : ReporterUtility refReporterUtility
	ReturnType : null
	************************************************* */
	public void frameworkAndPropertyfilePathInitialization() {
		try{
			//FrameworkAndPropertyFilePath
			gstrFramework_Path=System.getProperty("user.dir");
			strGlobalPropertyFile_Path=gstrFramework_Path+"\\src\\main\\resources\\global.properties";
			Reporter.log("GlobalInitialization: Framework path and property file path initialzed", true);
		}catch (Exception e) {
			Reporter.log("ERROR: Exception at globalInitialization: frameworkAndPropertyfilePath_Initialization", true);
			Reporter.log("ERROR: StackTrace: "+e.toString());	
				throw e;
		}
	}
		
	/* ************************************************* 
	Function Name : propertyFile_Initialization 
	Description : This function is used to initialize property file
	Input parameters : ReporterUtility refReporterUtility
	ReturnType : null
	************************************************* */
	public void  propertyFileInitialization() {
		try{
			//PropertyFIleInitializer
			grefGlobalProperties= FileUtils.PropertyFileInitialization(strGlobalPropertyFile_Path);
			PropertyFileInitializer.PathAndVariableInitializer();
			Reporter.log("GlobalInitialization: Property file initialized", true);
		}catch (Exception e) {
			Reporter.log("ERROR: Exception at globalInitialization: propertyFile_Initialization", true);
			Reporter.log("ERROR: StackTrace: "+e.toString());	
				throw e;
		}
	}
		
	/* ************************************************* 
	Function Name : Reporter_initialization 
	Description : This function is used to initialize Reporter
	Input parameters : ReporterUtility refReporterUtility
	ReturnType : null
	************************************************* */
	public void ReporterInitialization() {
		try{
			//Reporter Initialization
			initialize(gstrReporterType);
			Reporter.log("GlobalInitialization: Reporter initialized", true);				
		}catch (Exception e) {
			Reporter.log("ERROR: Exception at globalInitialization: Reporter_initialization", true);
			Reporter.log("ERROR: StackTrace: "+e.toString());	
				throw e;
		}
	}
			
		
	/* ************************************************* 
	Function Name : globalInitialization 
	Description : This function is used as assembly to perform the following operations: initialize Paths(Framework and Property file), objects, property file and reports.
	Input parameters : ReporterUtility refReporterUtility
	ReturnType : String (Type of Report)
	************************************************* */
	public void globalInitialization() throws Exception {
		Reporter.log("******************** GlobalInitialization: Started ********************", true);
		classObjectInitialization();
		frameworkAndPropertyfilePathInitialization();
		propertyFileInitialization();
		ReporterInitialization();
		Reporter.log("******************** GlobalInitialization: End ********************", true);
	}
		
	public void SuiteAssembly() throws Exception {
		globalInitialization();	
		RestAssuredUtils.ProxySetup();
	}

}
