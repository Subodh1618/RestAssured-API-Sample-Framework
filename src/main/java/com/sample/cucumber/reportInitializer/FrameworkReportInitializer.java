package com.sample.cucumber.reportInitializer;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import core.reporter.ReporterBridge;
import core.reporter.HTML;

/**
 * @author Subodh Kumar
 *
 */

public class FrameworkReportInitializer {

	//Variables
	public static String gstrResult_Path;
	public static String gstrScenarioName;
	public static String gstrCategory;
	public static String gstrModule;
	public static String gstrStoryId;
	public static String gstrType;
	
	//Reporter reference declarations
	private static ReporterBridge grefReporterBridge;
		
	/* ************************************************* 
	Function Name : initialize 
	Description : This function is used to initiaze a reporting type
	Input parameters : strType - Type of the report that needs to be initialized
	ReturnType : void
	************************************************* */
	public static void initialize(String strReporterType){
		switch (strReporterType) {
			case "htmlReport":
				grefReporterBridge=new HTML();
				grefReporterBridge.reportInitialization(gstrResult_Path,"MDC Test Report","MDC Services Test Execution Report");
				break;
			default:
				Assert.assertTrue(false, " Reporter-Initialize : No matching reporting type ");
			}		
	}
		
	/* ************************************************* 
	Function Name : startTest 
	Description : This function is used to start a test
	Input parameters : strType - Type of the report that needs to be initialized
					   straryScenarioOutlineArr- Scenario outline string array
	ReturnType : void
	************************************************* */
	public static void startTest(){
		grefReporterBridge.startTest(gstrStoryId, gstrScenarioName, gstrModule, gstrType, gstrCategory);
		Reporter.log("*************************************** Start Test: "+gstrScenarioName+" ***************************************", true);
		Reporter.log("***** StoryID: "+gstrStoryId+" | Module: "+gstrModule+" | Type: "+gstrType+" | Category: "+gstrCategory+" *****", true);
	}
		
	/* ************************************************* 
	Function Name : log 
	Description : This function is used to log
	Input parameters : strType - Type of the report that needs to be initialized
					   strLogStatus - Status of the log
					   strLogContent - content to be logged
	ReturnType : void
	************************************************* */
	public static void log(String strLogStatus, String strLogPhase, String strLogContent){
		grefReporterBridge.log(strLogStatus, strLogPhase, strLogContent);
		
		switch (strLogStatus) {
			case "INFO":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("INFO: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("INFO: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("INFO: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("INFO: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("INFO: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("INFO: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("INFO: @Background - "+strLogContent, true);
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			case "ERROR":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("ERROR: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("ERROR: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("ERROR: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("ERROR: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("ERROR: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("ERROR: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("ERROR: @Background - "+strLogContent, true);
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			case "EXCEPTION":
				switch (strLogPhase.toUpperCase()) {
					case "EXCEPTION":
						Reporter.log("EXCEPTION: @Exception - "+strLogContent, true);
						break;
				default:
					Assert.assertTrue(false, " HTML Report : No matching log phase ");
				}
				break;
			case "WARNING":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("WARNING: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("WARNING: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("WARNING: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("WARNING: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("WARNING: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("WARNING: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("WARNING: @Background - "+strLogContent, true);
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			case "FATAL":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("FATAL: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("FATAL: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("FATAL: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("FATAL: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("FATAL: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("FATAL: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("FATAL: @Background - "+strLogContent, true);;
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			case "SKIP":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("SKIP: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("SKIP: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("SKIP: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("SKIP: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("SKIP: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("SKIP: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("SKIP: @Background - "+strLogContent, true);;
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			case "UNKNOWN":
				switch (strLogPhase.toUpperCase()) {
					case "GIVEN":
						Reporter.log("UNKNOWN: @Given - "+strLogContent, true);
						break;
					case "WHEN":
						Reporter.log("UNKNOWN: @When - "+strLogContent, true);
						break;
					case "THEN":
						Reporter.log("UNKNOWN: @Then - "+strLogContent, true);
						break;
					case "AND":
						Reporter.log("UNKNOWN: @And - "+strLogContent, true);
						break;
					case "BEFORE":
						Reporter.log("UNKNOWN: @Before - "+strLogContent, true);
						break;
					case "AFTER":
						Reporter.log("UNKNOWN: @After - "+strLogContent, true);
						break;
					case "BACKGROUND":
						Reporter.log("UNKNOWN: @Background - "+strLogContent, true);;
						break;
				default:
					Assert.assertTrue(false, " TestNGReport : No matching log phase ");
				}
				break;
			default:
				Assert.assertTrue(false, " Reporter-Log-HTMLReport : No matching log status ");
		}
	}
	
	public static void responseCapture(String Response){
		grefReporterBridge.responseCapture(Response);
		Reporter.log("** Response: "+Response+" **", true);
	}
	
	public static void requestCapture(String Request){
		grefReporterBridge.requestCapture(Request);
		Reporter.log("** Request: "+Request+" **", true);
	}
	
	public static void responseHeaders(String respHeaders){
		grefReporterBridge.responseHeaderCapture(respHeaders);
		Reporter.log("** Response Headers: "+respHeaders+" **", true);
	}
		
	/* ************************************************* 
	Function Name : endTest 
	Description : This function is used to end a test
	Input parameters : strType - Type of the report that needs to be initialized
	ReturnType : void
	************************************************* */
	public static void endTest(){
		grefReporterBridge.endTest(gstrScenarioName);
		Reporter.log("**************************************** End Test: "+gstrScenarioName+" ****************************************", true);
	}
		
	/* ************************************************* 
	Function Name : flush 
	Description : This function is used to flush a reporting type
	Input parameters : strType - Type of the report that needs to be initialized
	ReturnType : void
	************************************************* */
	public static void flush() throws IOException{
		grefReporterBridge.flush(gstrResult_Path+"//HTMLReport.html");
	}
		
	public static void result(String strContent){
		grefReporterBridge.result(strContent);
		Reporter.log("Result: "+strContent, true);
	}
	 
	public static void requestInitialization(String baseUrl, String EndPoint){
		grefReporterBridge.requestInitialization(baseUrl, EndPoint);
		Reporter.log(" ********* BaseURL: "+baseUrl+" | EndPoint: "+EndPoint+" ********* ", true);
	}
	
}
