package com.sample.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceTestConfig {

		private  Map<String,String> serviceUrls;
		private String BaseUrl;
		private String Endpoint;
		private String proxyHost;
		private int proxyPort;
		private boolean setProxy;
		private String accessTokenURL;
		private String accessTokenEndpoint;
		private String grantType;
		private String scope;
		private String clientId;
		
		private static ServiceTestConfig testConfig = loadServiceTestConfig();
		
		private static ServiceTestConfig loadServiceTestConfig() {
			ObjectMapper obj = new ObjectMapper(new YAMLFactory());
            try {
                   return obj.readValue(new File("./src/main/resources/testConfig.yml"), ServiceTestConfig.class);
            } catch (IOException e) {
                   System.out.println("Exception while loading test config !!!");
                   e.printStackTrace();
            }
            return null;
            
      }

	public static  ServiceTestConfig getConfig(){
		if(testConfig!=null){
			return testConfig;
		}
		return new ServiceTestConfig();
	}
}
