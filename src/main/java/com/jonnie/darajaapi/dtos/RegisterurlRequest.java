package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterurlRequest {
    @JsonProperty("ShortCode")
    private String shortCode;
    @JsonProperty("ConfirmationURL")
    private String confirmationUrl;
    @JsonProperty("ValidationURL")
    private String validationUrl;
    @JsonProperty("ResponseType")
    private String responseType;
}
