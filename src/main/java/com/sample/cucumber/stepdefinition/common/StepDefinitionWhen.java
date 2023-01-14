package com.sample.cucumber.stepdefinition.common;

import com.sample.cucumber.MasterClass;
import com.sample.utilities.RestAssuredUtils;
import com.sample.utilities.ServiceTestConfig;

import core.reporter.Logstep;
import cucumber.api.java.en.When;

/**
 * @author Subodh Kumar
 *
 */

public class StepDefinitionWhen extends MasterClass {

	private ServiceTestConfig config = ServiceTestConfig.getConfig();
	
	
	//****************************************************Having no path parameter************************************************************************************************
	
	@When("^Get request is triggered for the following endpoint: \"([^\"]*)\"$")
	public void get_request_is_triggered_for_the_following_endpoint(String EndPoint) throws Throwable {
		gResponse= RestAssuredUtils.Get(Logstep.WHEN(), gRequest,config.getServiceUrls().get(EndPoint));
	}
	
	@When("^Put request is triggered for the following endpoint: \"([^\"]*)\"$")
	public void put_request_is_triggered_for_the_following_endpoint(String EndPoint) throws Throwable {
		gResponse=RestAssuredUtils.Put(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint));
	}
	
	@When("^Post request is triggered for the following endpoint: \"([^\"]*)\"$")
	public void Post_request_is_triggered_for_the_following_endpoint(String EndPoint) throws Throwable {
		gResponse=RestAssuredUtils.Post(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint));
	}
	
	@When("^Delete request is triggered for the following endpoint: \"([^\"]*)\"$")
	public void delete_request_is_triggered_for_the_following_endpoint(String EndPoint) throws Throwable {
		gResponse=RestAssuredUtils.Delete(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint));
	}
		
	
	//***********************************************Having one path parameter****************************************************************************************************
	
	@When("^Get request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\"$")
	public void Get_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1) throws Throwable {
		gResponse=RestAssuredUtils.Get(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1);
	}
	
	@When("^Put request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\"$")
	public void put_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1) throws Throwable {
		gResponse=RestAssuredUtils.Put(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1);
	}
	
	@When("^Post request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\"$")
	public void Post_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1) throws Throwable {
		gResponse=RestAssuredUtils.Post(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1);
	}
	
	@When("^Delete request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\"$")
	public void delete_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1) throws Throwable {
		gResponse=RestAssuredUtils.Delete(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1);
	}
	
	
	//************************************************Having two path Parameters***************************************************************************************************
	
	@When("^Get request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void get_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1, String pathParam2) throws Throwable {
		gResponse=RestAssuredUtils.Get(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1, pathParam2);
	}
	
	@When("^Put request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void put_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1, String pathParam2) throws Throwable {
		gResponse=RestAssuredUtils.Put(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1, pathParam2);
	}
	
	@When("^Post request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void Post_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1, String pathParam2) throws Throwable {
		gResponse=RestAssuredUtils.Post(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1, pathParam2);
	}
	
	@When("^Delete request is triggered for the following endpoint and path parameters: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void delete_request_is_triggered_for_the_following_endpoint_and_path_parameters(String EndPoint, String pathParam1, String pathParam2) throws Throwable {
		gResponse=RestAssuredUtils.Delete(Logstep.WHEN(), gRequest, config.getServiceUrls().get(EndPoint), pathParam1, pathParam2);
	}

}
