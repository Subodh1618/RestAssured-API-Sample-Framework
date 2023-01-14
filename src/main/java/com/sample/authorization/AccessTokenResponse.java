package com.sample.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * The class represents a parsed successful response received for the token endpoint request from a provider.
 * 
 * @author Subodh Kumar
 *
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenResponse {

    /**
     * The access token issued by the authorization server.
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * token_type from map-data provider
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * expires_in from map-data provider
     */
    @JsonProperty("expires_in")
    private long expiresIn;
}
