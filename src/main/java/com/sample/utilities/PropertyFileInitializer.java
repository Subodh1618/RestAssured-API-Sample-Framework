package com.sample.utilities;

import com.sample.cucumber.MasterClass;

/**
 * @author Subodh Kumar
 *
 */

public class PropertyFileInitializer extends MasterClass {
	
	public static void PathAndVariableInitializer(){
		
		//Result path
		gstrResult_Path=gstrFramework_Path+grefGlobalProperties.getProperty("gstrResult_Path")+gstrTimeStamp;
		//Variables
		gstrReporterType=grefGlobalProperties.getProperty("ReporterType");
		
		
	}
	
	
}
