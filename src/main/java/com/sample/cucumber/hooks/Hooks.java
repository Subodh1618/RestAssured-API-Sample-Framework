/**
 * Copyright 2017 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.*/

package com.sample.cucumber.hooks;

import com.sample.utilities.CucumberUtils;
import cucumber.api.java.Before;

import com.sample.cucumber.MasterClass;

import core.reporter.Logstep;
import core.reporter.Logtype;
import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * @author Subodh Kumar
 *
 */

public class Hooks extends MasterClass{
	
	@Before
	public void Before(Scenario scenario) {
		CucumberUtils.PreRequisites(scenario);
	}
	
	@After
	public void After(Scenario scenario) {
		//RestAssured.reset();
		try {
			boolean Result=scenario.isFailed();
			if(Result==false) {
				 result("Passed");
			}else {
				 result("Failed");
			}
			//Reseting Request and Response
			gRequest=null;
			gResponse=null;
		} catch(Exception e) {
			gRequest=null;
			gResponse=null;
			 log( Logtype.ERROR(),Logstep.AFTER(), "Exception at Hooks @After");
			 log( Logtype.ERROR(),Logstep.AFTER(), "StackTrace: "+e.toString());
		}
		endTest();
	}

}
