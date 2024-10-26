package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenResponse {
    @JsonProperty("access_token")
    private String access_token;

    @JsonProperty("expires_in")
    private String expiresIn;

    @SneakyThrows
    public String toString(){
        return new ObjectMapper().writeValueAsString(this);
    }
}
