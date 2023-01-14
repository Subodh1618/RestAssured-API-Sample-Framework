package com.sample.utilities;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.Reporter;

import com.sample.cucumber.MasterClass;
import core.reporter.Logstep;
import core.reporter.Logtype;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Subodh Kumar
 *
 */

public class RestAssuredUtils extends MasterClass {
	
	private static ServiceTestConfig config = ServiceTestConfig.getConfig();
	
	public static void statusCodeAssertion(String stepName, Response repsonse, int statusCode) {
		try{
			log( Logtype.INFO(), stepName,"Status code "+statusCode+" should be verified");
				//Assertion of Status code
				int statusResponse=repsonse.statusCode();
				Assertion.assertEquals(statusResponse, statusCode, stepName, "Assertion of StatusCode");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
	}
	
	public static Response Get(String stepName, RequestSpecification request, String endpoint, String ... pathParam) throws Exception {
		Response response;
		try	{
			String endPoint=endpointConstructor(endpoint, pathParam);
			response=request.get(endPoint);
			log( Logtype.INFO(), stepName,"GET request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	public static Response Get(String stepName, RequestSpecification request, String endpoint) throws Exception {
		Response response;
		try	{
			response=request.get(endpoint);
			log( Logtype.INFO(), stepName,"GET request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	
	public static Response Post(String stepName, RequestSpecification request, String endpoint) throws Exception {
		Response response;
		try	{
			response=request.post(endpoint);
			log( Logtype.INFO(), stepName,"POST request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	

	public static Response Post(String stepName, RequestSpecification request, String endpoint, String ... pathParam) throws Exception {
		Response response;
		try	{
			String endPoint=endpointConstructor(endpoint, pathParam);
			response=request.post(endPoint);
			log( Logtype.INFO(), stepName,"POST request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	
	public static Response Put(String stepName, RequestSpecification request, String endpoint, String ... pathParam) throws Exception {
		Response response;
		try	{
			String endPoint=endpointConstructor(endpoint, pathParam);
			response=request.put(endPoint);
			log( Logtype.INFO(), stepName,"PUT request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	public static Response Put(String stepName, RequestSpecification request, String endpoint) throws Exception {
		Response response;
		try	{
			response=request.put(endpoint);
			log( Logtype.INFO(), stepName,"PUT request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	public static Response Delete(String stepName, RequestSpecification request, String endpoint, String ... pathParam) throws Exception {
		Response response;
		try	{
			String endPoint=endpointConstructor(endpoint, pathParam);
			response=request.delete(endPoint);
			log( Logtype.INFO(), stepName,"DELETE request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	public static Response Delete(String stepName, RequestSpecification request, String endpoint) throws Exception {
		Response response;
		try	{
			response=request.delete(endpoint);
			log( Logtype.INFO(), stepName,"DELETE request to be triggered - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+stepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return response;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL,EndPoint);
			log( Logtype.INFO(), StepName, StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given();
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> headers) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL,EndPoint);
			log( Logtype.INFO(), StepName, StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().headers(headers);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, String contentType, Map<String, Object> headers, byte[] body) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL,EndPoint);
			log( Logtype.INFO(), StepName, StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().contentType(contentType).headers(headers).body(body);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> headers, byte[] body) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL,EndPoint);
			log( Logtype.INFO(), StepName, StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().headers(headers).body(body);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> headers, File body) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL,EndPoint);
			log( Logtype.INFO(), StepName, StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().headers(headers).body(body);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> headers, Map<String, Object> QueryParam) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL, EndPoint);
			log( Logtype.INFO(), StepName,StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().headers(headers).queryParams(QueryParam);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> headers, Map<String, Object> QueryParam, Map<String,Object> body, String contentType) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL, EndPoint);
			log( Logtype.INFO(), StepName,StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().contentType(contentType).headers(headers).queryParams(QueryParam).body(body);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	public static RequestSpecification requestFormation(String StepName, String EndPoint, String StepDescription, String baseURL, Map<String, Object> QueryParam, Map<String,Object> body, String contentType) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL, EndPoint);
			log( Logtype.INFO(), StepName,StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().contentType(contentType).queryParams(QueryParam).body(body);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}

	
	public static RequestSpecification authRequestFormation(String StepName,String EndPoint, String StepDescription, String baseURL,Map<String, Object> headers, Map<String, String> formParam) {
		RequestSpecification gRequest;
		try	{
			requestInitialization(baseURL, EndPoint);
			log( Logtype.INFO(), StepName,StepDescription);
			RestAssured.baseURI = baseURL;
			gRequest=given().contentType(ContentType.URLENC.withCharset("UTF-8")).formParams(formParam);
			log( Logtype.INFO(), StepName,"BaseURL-"+baseURL+", initialization - Successfull");
			log( Logtype.INFO(), StepName,"Formation of the request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at "+StepName);
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return gRequest;
	}
	
	
	public static String endpointConstructor(String EndPoint, String ... Parameters ) throws Exception {
		String NewEndPoint = null;
		try	{
			String strContainer1= EndPoint.replace("{", "::");
			String strContainer2= strContainer1.replace("}", "::");
			String[] arrFinalContainer=strContainer2.split("::");
			//Converting the arr to Map
			Map<Integer, String> mapFinalContainer = new HashMap<Integer, String>();
			for(int i=0; i<arrFinalContainer.length; i++) {
				mapFinalContainer.put(i, arrFinalContainer[i]);
			}
			//Fetching the total count of parameters in Final container
			int mFinalCount = 0;
			for(int i=0; i<mapFinalContainer.size(); i++) {
				if(!(mapFinalContainer.get(i).contains("/"))) {
					 mFinalCount=mFinalCount+1;
				}
			}
			//Fetching the count of parameters 
			int parametersCount=Parameters.length;
			
			//Initial Checkpoint for size of containers
			if(parametersCount==mFinalCount) {
			}else{
				throw new Exception();
			}
			//Replacing the parameters with actual value
			int counter=0;
			for(int i=0; i<mapFinalContainer.size(); i++) {
				if(!(mapFinalContainer.get(i).contains("/"))) {
					mapFinalContainer.replace(i, Parameters[counter]);
					counter=counter+1;
				}
			 }
			 //Forming a new endpoint
			 for(int i=0; i<mapFinalContainer.size(); i++) {
				 if(i==0) {
					 NewEndPoint= mapFinalContainer.get(i);
				 }else {
					 NewEndPoint=NewEndPoint+ mapFinalContainer.get(i); 
				 }
			 }
			 log(Logtype.INFO(),Logstep.WHEN(), "EndPoint with the path-Parameter= "+NewEndPoint);
			 return NewEndPoint;
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at Utility: EndPoint constructor");
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
	}

	
	/*public static String generateAccessToken() {
		String accessToken;
		try	{
				/*PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
				    auth.setUserName(proxyUserName);
				    auth.setPassword(proxyPassword); */
				/*RestAssured.proxy(config.getProxyHost(), config.getProxyPort());
				RestAssured.baseURI = config.getBaseURL_accessToken();
				log(Logtype.INFO(), Logstep.GIVEN(),"Initiating accessToken generation process");	
				Response accessTokenResponse = RestAssured.given()
													.config(RestAssured.config()
													.encoderConfig(EncoderConfig.encoderConfig()
													.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC)))
													.contentType("application/x-www-form-urlencoded; charset=UTF-8")
													.formParam("grant_type", config.getGrant_type())
													.formParam("scope", config.getScope())
													.formParam("client_id", config.getClient_id())
													.formParam("client_secret", config.getClient_secret())
													.post(config.getEndpoint_accessToken());						
				int statusCode = accessTokenResponse.getStatusCode();
				Assertion.assertEquals(statusCode, 200, Logstep.GIVEN(), "Assertion of Access Token status code");
				JsonPath pathEvaluator = new JsonPath(accessTokenResponse.asString());
				accessToken=pathEvaluator.get("access_token");
				log( Logtype.INFO(), Logstep.GIVEN(),"Access Token Generation Request - Successfull");
		}catch(Exception e){
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at utility: generateAccessToken");
			log( Logtype.EXCEPTION(),Logstep.EXCEPTION(), "StackTrace: "+e.toString());
				throw e;
		}
		return accessToken;
	} */
	
	     
    public static Map<String, Object> mapKeyVal(String stepName, String type, String strKeyVal) throws Throwable {
        try{
           String str = strKeyVal;
           Map<String,Object> KeyVal = new HashMap<>();
           String[]  strKeyValArray = str.split(",");
           for(int i=0;i<strKeyValArray.length;i++){
               String splittedStr = strKeyValArray[i].trim();
               String[] KeyValArray = splittedStr.split(":");
               if(KeyValArray.length==1) {
                   KeyVal.put(KeyValArray[0], "");
               }else if(KeyValArray.length==2) {
                   KeyVal.put(KeyValArray[0], KeyValArray[1]);
               }else {
                   log(Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at utility: mapKeyVal");
                   throw new Exception();
               }
           }
           log(Logtype.INFO(), stepName, type+": "+KeyVal);
           return KeyVal;
        }catch(Throwable t) {
            log(Logtype.EXCEPTION(), Logstep.EXCEPTION(),"Exception at utility: mapKeyVal");
            log(Logtype.EXCEPTION(), Logstep.EXCEPTION(), "StackTrace: "+t.toString());
                throw t;
        }
    }


    public static void ProxySetup() {
		try{
			if(gblnProxySetupFlag) {
				Reporter.log("******************** Proxy setup: Started ********************", true);
				//PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
			    //auth.setUserName(proxyUserName);
			    //auth.setPassword(proxyPassword);
				RestAssured.proxy(config.getProxyHost(), config.getProxyPort());
				Reporter.log("******************** Proxy setup: Completed ********************", true);
			}
			} catch(Exception e) {
				Reporter.log("ERROR: Exception at ProxySetup", true);
				Reporter.log("ERROR: StackTrace: "+e.toString());	
					throw e;
		}
	} 

}


