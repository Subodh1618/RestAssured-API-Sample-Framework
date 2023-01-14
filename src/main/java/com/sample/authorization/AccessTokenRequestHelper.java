package com.sample.authorization;

/**
* @author Subodh Kumar
*
*/

public class AccessTokenRequestHelper {
	
	private static AccessToken accessToken = new AccessTokenManager();
	
	public static AccessToken getInstance(){
		return accessToken;		
	}

}
