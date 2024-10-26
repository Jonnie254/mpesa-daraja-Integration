package com.jonnie.darajaapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonnie.darajaapi.config.MpesaConfiguration;
import com.jonnie.darajaapi.dtos.*;
import com.jonnie.darajaapi.utils.HelperUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

import static com.jonnie.darajaapi.utils.Constants.*;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class DarajaApiImpl implements DarajaApi {
    private final MpesaConfiguration mpesaConfiguration;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    @Override
    public AccessTokenResponse getAccessToken() {
        String encodedCredentials = HelperUtility.toBase64String(
                String.format("%s:%s", mpesaConfiguration.getConsumerKey(), mpesaConfiguration.getConsumerSecret())
        );
        Request request = new Request.Builder()
              .url(String.format("%s?grant_type=%s", mpesaConfiguration.getOauthEndpoint(), mpesaConfiguration.getGrantType()))
                .get()
                .addHeader(AUTHORIZATION_HEADER_STRING, format("%s %s", BASIC_AUTH_STRING,encodedCredentials))
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.body() == null) {
                return null;
            }
           String responseBody = response.body().string();
           return objectMapper.readValue(responseBody, AccessTokenResponse.class);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public RegisterUrlResponse registerUrl() {
        AccessTokenResponse accessTokenResponse = getAccessToken();
        String accessToken = accessTokenResponse.getAccess_token();
        log.info("Access token -> {}", accessToken);

        RegisterurlRequest registerurlRequest = new RegisterurlRequest();
        registerurlRequest.setConfirmationUrl(mpesaConfiguration.getConfirmationUrl());
        registerurlRequest.setValidationUrl(mpesaConfiguration.getValidationUrl());
        registerurlRequest.setShortCode(mpesaConfiguration.getShortCode());
        registerurlRequest.setResponseType(mpesaConfiguration.getResponseType());

        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJsonString(registerurlRequest)));
        Request request = new Request.Builder()
                .url(mpesaConfiguration.getRegisterUrl())
                .post(requestBody)
                .addHeader(AUTHORIZATION_HEADER_STRING, format("%s %s", BEARER_AUTH_STRING, accessToken))
                .build();
        log.info("Request -> {}", request);
        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String responseBody = response.body().string();
            log.info("Raw Response: {}", responseBody);
            return objectMapper.readValue(responseBody, RegisterUrlResponse.class);
        } catch (IOException e) {
            log.error("Error occurred while registering the URLs -> {}", e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public SimulateC2BResponse simulateC2BTransaction(SimulateC2BRequest simulateC2BRequest) {
        AccessTokenResponse accessTokenResponse = getAccessToken();
        RequestBody requestBody = RequestBody.create(
                JSON_MEDIA_TYPE,
                Objects.requireNonNull(HelperUtility.toJsonString(simulateC2BRequest))
        );
        Request request = new Request.Builder()
                .url(mpesaConfiguration.getSimulateUrl())
                .post(requestBody)
                .header(AUTHORIZATION_HEADER_STRING, format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccess_token()))
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, SimulateC2BResponse.class);
        } catch (IOException e) {
            log.error("Error occurred while simulating the transaction -> {}", e.getLocalizedMessage());
            return null;
        }
    }
}