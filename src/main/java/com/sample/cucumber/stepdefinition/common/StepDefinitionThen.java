package com.sample.cucumber.stepdefinition.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sample.cucumber.MasterClass;
import com.sample.utilities.Assertion;
import com.daimler.daivb.mdc.utilities.MDCUtils;
import com.sample.utilities.RestAssuredUtils;
import com.sample.utilities.ServiceTestConfig;

import core.reporter.Logstep;
import core.reporter.Logtype;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;

/**
 * @author Subodh Kumar
 *
 */

public class StepDefinitionThen extends MasterClass{
	
	private ServiceTestConfig config = ServiceTestConfig.getConfig();

	//************************************************** General Response Verifications ***********************************************************************************************************************************************************************************	
	//Response Status Code verification
	@Then("^Status code \"([^\"]*)\" should be verified$")
	public void status_code_should_be_verified(int statusCode) throws Throwable {
		RestAssuredUtils.statusCodeAssertion(Logstep.THEN(), gResponse, statusCode);
		log(Logtype.INFO(),Logstep.AND(),"Status code Verification-Successfull");
	}

	//Response header capture and verification	
	@Then("^Response code \"([^\"]*)\" in the header response should be verified$")
	public void header_response_should_be_captured_and_response_code_message_should_be_verified_using_following_parameters(String responseCode) throws Throwable {
		log(Logtype.INFO(),Logstep.AND(),"Verification of response headers :");
		String actualRespCode = gResponse.getHeader("X-Snap-Data");
		Assertion.assertEquals(actualRespCode, responseCode, Logstep.AND(), "Assertion of response code");
	}

}
