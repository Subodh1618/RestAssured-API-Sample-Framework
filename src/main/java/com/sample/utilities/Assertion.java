package com.sample.utilities;

import java.util.List;

import org.testng.Assert;

import com.sample.cucumber.MasterClass;

import core.reporter.Logstep;
import core.reporter.Logtype;

public class Assertion extends MasterClass{

	public static void softAssertAttributeNotNull(String actual, String logstep, String attributeName, String content) {
		if(!(actual==null)) {
			log(Logtype.INFO(), logstep, content);	
		}else {
			log(Logtype.WARNING(), logstep, attributeName+" Attribute is null");
		}
	}
	
	public static void assertEquals(String actual, String expected, String strLogPhase, String Content) {
		try{
			Assert.assertEquals(actual, expected);
			log(Logtype.INFO(), strLogPhase, Content +": ( Successfull- Expected: "+expected+" | Actual: "+actual+")");
		}catch(Throwable t) {
			log(Logtype.EXCEPTION(), Logstep.EXCEPTION(), Content+" - (Failed - Expected: "+expected+" and Actual: "+actual+")");
				throw t;
		}
	}
	

	public static void hardAssertAttributeNotNull(Object actual, String attributeName, String logstep, String content) throws Exception {
		try{
			if(!(actual==null)) {
			log(Logtype.INFO(), logstep, content);	
			log(Logtype.INFO(), logstep, "Attribute '"+attributeName+"' displayed as : "+actual);
			}else {
				log(Logtype.EXCEPTION(), logstep, attributeName+" attribute is null");
				throw new Exception("Attribute displayed is Null");
			}
		}catch(Throwable t)	{
			throw t;
		}
	}

	public static void hardAssertAttributeNull(String actual, String attributeName, String logstep, String content) throws Exception {
		try{
			if(actual==null) {
			    log(Logtype.INFO(), logstep, content);
			    log(Logtype.INFO(), logstep, "Attribute '"+attributeName+"' displayed as : "+actual);
			}else {
				log(Logtype.EXCEPTION(), logstep, attributeName+" attribute is not null");
				throw new Exception("Attribute displayed is Not Null");
			}
		}catch(Throwable t)	{
			throw t;
		}
	}
	
	
	public static void assertEqualsStringIgnoreCase(String actual, String expected, String strLogPhase, String content) {
		try{
			if(actual.equalsIgnoreCase(expected)) {
			log(Logtype.INFO(), strLogPhase, content +": ( Successfull- Expected: "+expected+" | Actual: "+actual+")");
			}else {
				log(Logtype.EXCEPTION(), strLogPhase, "Expected Value doesn't match with Actual value");
			}
		}catch(Throwable t) {
			log(Logtype.EXCEPTION(), Logstep.EXCEPTION(), content+" - (Failed - Expected: "+expected+" and Actual: "+actual+")");
				throw t;
		}
	}
	
	
	public static void assertFalse(boolean actual, String attributeName, String logstep, String content) {
		try{
			Assert.assertFalse(actual);
			log(Logtype.INFO(), logstep, content+" : (Expected:false | Actual: "+actual+")");	
		}catch(Throwable t) {
			log(Logtype.EXCEPTION(), logstep, attributeName+" Attribute is not False");
			throw t;
		}
	}
	

	public static void assertTrue(boolean actual, String attributeName, String logstep, String content) {
		try{
			Assert.assertTrue(actual);
			log(Logtype.INFO(), logstep, content+" : (Expected: true | Actual: "+actual+")");	
		}catch(Throwable t) {
			log(Logtype.EXCEPTION(), logstep, attributeName+" Attribute is not True");
			throw t;
		}
	}

	
	public static void assertEquals(int actual, int expected, String strLogPhase, String content) {
		try{
			Assert.assertEquals(actual, expected);
			log(Logtype.INFO(), strLogPhase, content+": (Successfull- Expected: "+expected+" | Actual: "+actual+")");
		}catch(Throwable t) {
			log(Logtype.EXCEPTION(), Logstep.EXCEPTION(), content+" - (Failed - Expected: "+expected+" and Actual: "+actual+")");
				throw t;
		}
	}

	
	public static void assertContains(String container, String toVerify,  String strLogPhase, String content) {
		try{
			if(container.contains(toVerify)) {
				log( Logtype.INFO(), strLogPhase,content+": Successfull- Response contains the following: "+toVerify);
			}else {
				log( Logtype.ERROR(), strLogPhase,content+": Failed- Response contains unexpected value: "+toVerify);
				Assert.assertTrue(false, "ERROR: Exception at Assert_Contains");
			}
		}catch(Throwable t) {
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION()," Exception at Assert_Contains");
				throw t;
		}
	}	
	
	public static void assertContains(List<String> container, String toVerify,  String strLogPhase, String content) {
		try{
			if(container.contains(toVerify)) {
				log( Logtype.INFO(), strLogPhase,content+": Successfull- Response contains the following: "+toVerify);
			}else {
				log( Logtype.ERROR(), strLogPhase,content+": Failed- Response contains unexpected value: "+toVerify);
				Assert.assertTrue(false, "ERROR: Exception at Assert_Contains");
			}
		}catch(Throwable t) {
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION()," Exception at Assert_Contains");
				throw t;
		}
	}
	
	public static void assertContains(List<Integer> container, int toVerify,  String strLogPhase, String content) {
		try{
			if(container.contains(toVerify)) {
				log( Logtype.INFO(), strLogPhase,content+": Successfull- Response contains the following: "+toVerify);
			}else {
				log( Logtype.ERROR(), strLogPhase,content+": Failed- Response contains unexpected value: "+toVerify);
				Assert.assertTrue(false, "ERROR: Exception at Assert_Contains");
			}
		}catch(Throwable t) {
			log( Logtype.EXCEPTION(), Logstep.EXCEPTION()," Exception at Assert_Contains");
				throw t;
		}
	}
	
}
