package com.jonnie.darajaapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")

public class MpesaConfiguration {

    private String consumerKey;
    private String consumerSecret;
    private String grantType;
    private String oauthEndpoint;
    private String shortCode;
    private String responseType;
    private String confirmationUrl;
    private String validationUrl;
    private String registerUrl;
    private String simulateUrl;
    private String b2cTransactionUrl;
    private String b2cResultUrl;
    private String b2cQueueTimeoutUrl;
    private String b2cInitiatorName;
    private String b2cInitiatorPassword;

    public String toString() {
        return String.format("consumerKey: %s, consumerSecret: %s, grantType: %s, oauthEndpoint: %s", consumerKey, consumerSecret, grantType, oauthEndpoint);
    }
}
