package com.jonnie.darajaapi.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUrlResponse {
    @JsonProperty("ConversationID")
    private String ConversationID;
    @JsonProperty("OriginatorCoversationID")
    private String responseDescription;
    @JsonProperty("ResponseCode")
    private String originatorCoversationID;
}
