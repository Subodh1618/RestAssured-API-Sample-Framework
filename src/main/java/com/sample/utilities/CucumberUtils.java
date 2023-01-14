package com.sample.utilities;

import org.testng.Assert;
import org.testng.Reporter;

import com.sample.cucumber.MasterClass;

import cucumber.api.Scenario;

/**
 * @author Subodh Kumar
 *
 */

public class CucumberUtils extends MasterClass{	
	
	/* ************************************************* 
	Function Name : fnGetScenarioOutline 
	Description : This function is used to get the entire screnariooutline of a scenario underexecution
	Input parameters : refScenario - reference of the scenario
	ReturnType : String
	************************************************* */
	public static String getScenarioOutline(Scenario refScenario){
		String scenarioOutline = null;
		try{
			scenarioOutline=refScenario.getName().toString();
		}catch(Exception e){
			Reporter.log("getScenarioOutline - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return scenarioOutline;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioOutlineArray 
	Description : This function is used to split the entire screnariooutline of a scenario underexecution and store it in a array
	Input parameters : strScenarioOutline - scenario outline
	ReturnType : String[]
	************************************************* */
	public static String[] getScenarioOutlineArray(String strScenarioOutline){
		String[] scenarioOutline = null;
		try{
			scenarioOutline=strScenarioOutline.split("\\|");
			if(scenarioOutline.length == 5){
			}else{
				Reporter.log("getScenarioOutline-Error: Length of the Scenario Outline is not equal to 5", true);
				Assert.assertFalse(true);
			}	
		}catch(Exception e){
			Reporter.log("getScenarioOutlineArray - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return scenarioOutline;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioName 
	Description : This function is used to get scenario name from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getScenarioName(String[] straryScenarioOutline){
		String ScenarioName= null;
		try{
		String[] ScenarioNameArr=straryScenarioOutline[1].split("::");
			ScenarioName=ScenarioNameArr[1].trim();
		}catch(Exception e){
			Reporter.log("getScenarioName - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return ScenarioName;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioEndPoint 
	Description : This function is used to get scenario module from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getScenarioModule(String[] straryScenarioOutline){
		String ScenarioModule= null;
		try{
		String[] ScenarioNameArr=straryScenarioOutline[2].split("::");
		ScenarioModule=ScenarioNameArr[1].trim();
		}catch(Exception e){
			Reporter.log("fnGetScenarioModule - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return ScenarioModule;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioStoryID
	Description : This function is used to get scenario StoryID from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getScenarioStoryID(String[] straryScenarioOutline){
		String ScenarioStoryID= null;
		try{
		String[] ScenarioNameArr=straryScenarioOutline[0].split("::");
		ScenarioStoryID=ScenarioNameArr[1].trim();
		}catch(Exception e){
			Reporter.log("fnGetScenarioStoryID - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return ScenarioStoryID;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioType
	Description : This function is used to get scenario Type from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getScenarioType(String[] straryScenarioOutline){
		String ScenarioType= null;
		try{
		String[] ScenarioNameArr=straryScenarioOutline[3].split("::");
		ScenarioType=ScenarioNameArr[1].trim();
		}catch(Exception e){
			Reporter.log("fnGetScenarioType - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return ScenarioType;
	}
	
	/* ************************************************* 
	Function Name : fnGetScenarioCategory 
	Description : This function is used to get scenario category from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getScenarioCategory(String[] straryScenarioOutline){
		String ScenarioCategory= null;
		try{
		String[] ScenarioNameArr=straryScenarioOutline[4].split("::");
		ScenarioCategory=ScenarioNameArr[1].trim();
		}catch(Exception e){
			Reporter.log("getScenarioName - Exception: "+ e.toString(), true);
			Assert.assertFalse(true);
		}
		return ScenarioCategory;
	}
	
	/* ************************************************* 
	Function Name : fnGetAuthor 
	Description : This function is used to get author name from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getAuthor(String[] straryScenarioOutline){
		String Author= null;
		try{
		String[] AuthorArr=straryScenarioOutline[1].split("-");
		Author=AuthorArr[1];
		}catch(Exception e){
			Reporter.log("getAuthor - Exception: "+e.toString(), true);
			Assert.assertFalse(true);
		}
		return Author;
	}
	
	/* ************************************************* 
	Function Name : fnGetCategory 
	Description : This function is used to get category name from the scenario outline array
	Input parameters : straryScenarioOutline - scenario outline string array
	ReturnType : String
	************************************************* */
	public static String getCategory(String[] straryScenarioOutline){
		String Category= null;
		try{
		String[] CategoryArr=straryScenarioOutline[2].split("-");
		Category=CategoryArr[1];
		}catch(Exception e){
			Reporter.log("getCategory - Exception: "+e.toString(), true);
			Assert.assertFalse(true);
		}
		return Category;
	}
	
	/* ************************************************* 
	Function Name : fnIterCounter 
	Description : This function is used to implement Iteration Counter
	Input parameters : strPrevScenarioOutline - previous scenario outline string array
					   strCurScenarioOutline - current scenario outline string array
					   intPrevCounter - counter's previous value
	ReturnType : int
	************************************************* */
	public static int iterCounter(String strPrevScenarioOutline, String strCurScenarioOutline, int intPrevCounter){
		int counter = 0;
		try{
			if(strCurScenarioOutline.equals(strPrevScenarioOutline)){
				counter=intPrevCounter+1;
			}else{
				counter=1;
			}
		}catch(Exception e){
			Reporter.log("IterCounter - Exception: "+e.toString(), true);
			Assert.assertFalse(true);
		}
		return counter;
	}
	
	/* ************************************************* 
	Function Name : PreRequisites 
	Description : This function is used to implement Pre Requisites for a scenario.
	Input parameters : Scenario scenario
	ReturnType : Void
	************************************************* */
	public static void PreRequisites(Scenario scenario){
		String ScenarioOutline=getScenarioOutline(scenario);
		String[] ScenarioOutlineArr=getScenarioOutlineArray(ScenarioOutline);
			gstrScenarioName=getScenarioName(ScenarioOutlineArr);
			gstrCategory=getScenarioCategory(ScenarioOutlineArr);
			gstrModule=getScenarioModule(ScenarioOutlineArr);
			gstrStoryId=getScenarioStoryID(ScenarioOutlineArr);
			gstrType=getScenarioType(ScenarioOutlineArr);
		//Reporter-StartTest	
		startTest();
				
	}
	
}
