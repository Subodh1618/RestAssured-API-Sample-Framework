package com.sample.authorization;

import java.time.Instant;
import com.sample.utilities.ServiceTestConfig;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
* @author Subodh Kumar
*
*/

public class AccessTokenManager implements AccessToken {

	private static final int ADVANCE_TIME_FOR_TOKEN_RENEWAL = 1800; // 5 mins

	private long accessTokenRequestStartTimeInSecs;
	private final Object lock = new Object();
	private AccessTokenResponse accessTokenResponse;
	private static ServiceTestConfig testConfig = ServiceTestConfig.getConfig();

	@Override
	public String getToken() {
		if (isTokenExpired(accessTokenRequestStartTimeInSecs, accessTokenResponse)) {
			synchronized (lock) {
				if (isTokenExpired(accessTokenRequestStartTimeInSecs, accessTokenResponse)) {
					accessTokenRequestStartTimeInSecs = Instant.now().toEpochMilli() / 1000;
					if(testConfig.isSetProxy()) {
						RestAssured.proxy(testConfig.getProxyHost(), testConfig.getProxyPort());
					}
					RestAssured.baseURI = testConfig.getAccessTokenURL();	
					Response response = RestAssured.given()
														.config(RestAssured.config()
														.encoderConfig(EncoderConfig.encoderConfig()
														.encodeContentTypeAs("x-www-form-urlencoded",ContentType.URLENC)))
														.contentType("application/x-www-form-urlencoded; charset=UTF-8")
														.accept("application/json")
														.formParam("grant_type", testConfig.getGrantType())
														.formParam("scope", testConfig.getScope())
														.formParam("client_id", testConfig.getClientId())
														.formParam("client_secret", "")
														.post(testConfig.getAccessTokenEndpoint());
					accessTokenResponse = response.getBody().as(AccessTokenResponse.class);
					System.out.println(
							"Received access token at " + Instant.now() + ", status: " + response.getStatusCode());
				}
			}
		}
		return accessTokenResponse.getAccessToken();
	}

	private boolean isTokenExpired(final long accessTokenRequestStartTimeInSecs,
			final AccessTokenResponse accessTokenResponse) {
		if (accessTokenRequestStartTimeInSecs == 0 || accessTokenResponse == null) {
			return true;
		}

		final Instant currentTimestamp = Instant.now();
		final Instant expiryTime = Instant.ofEpochSecond(accessTokenRequestStartTimeInSecs).plusSeconds(
				getRemainingExpiryTime(accessTokenResponse.getExpiresIn(), ADVANCE_TIME_FOR_TOKEN_RENEWAL));
		return currentTimestamp.isAfter(expiryTime);
	}

	private long getRemainingExpiryTime(final long actualExpiryTime, final long advanceTimeForTokenRenewal) {
		return actualExpiryTime - advanceTimeForTokenRenewal;
	}

}
