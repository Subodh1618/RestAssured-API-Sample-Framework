package com.sample.cucumber.stepdefinition.common;

import com.sample.authorization.AccessToken;
import com.sample.utilities.RestAssuredUtils;
import com.sample.utilities.ServiceTestConfig;
import core.reporter.Logstep;
import core.reporter.Logtype;
import cucumber.api.java.en.Given;
import java.util.Map;

import com.sample.authorization.AccessTokenRequestHelper;
import com.sample.cucumber.MasterClass;

/**
 * @author Subodh Kumar
 *
 */

public class StepDefinitionGivens extends MasterClass {
	
	private ServiceTestConfig config = ServiceTestConfig.getConfig();
	private static AccessToken accessToken = AccessTokenRequestHelper.getInstance();

	
	//Check connection Request Formation
	@Given("^User forms request using following parameters: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_prepares_a_POST_request_using_following_parameters(String baseURL, String endpoint, String header, String queryparameters) throws Throwable {
		Map<String,Object> headers = RestAssuredUtils.mapKeyVal(Logstep.GIVEN(), "Headers", header);
		Map<String,Object> queryParams = RestAssuredUtils.mapKeyVal(Logstep.GIVEN(), "QueryParams", queryparameters);
		headers.put("Authorization", "Bearer " + accessToken.getToken());
		gRequest = RestAssuredUtils.requestFormation(Logstep.GIVEN(), config.getServiceUrls().get(endpoint), "User prepares a POST request with a valid token", config.getServiceUrls().get(baseURL), headers);
	}
	
}
		
 

