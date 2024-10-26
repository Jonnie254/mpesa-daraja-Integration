package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CTransactionResponse{

	@JsonProperty("ConversationID")
	private String conversationID;

	@JsonProperty("ResponseCode")
	private String responseCode;

	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	@JsonProperty("ResponseDescription")
	private String responseDescription;
}