package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CTransactionRequest {

	@JsonProperty("QueueTimeOutURL")
	private String queueTimeOutURL;

	@JsonProperty("OriginatorConversationID")
	private String originatorConversationID;

	@JsonProperty("Remarks")
	private String remarks;

	@JsonProperty("Amount")
	private String amount;

	@JsonProperty("InitiatorName")
	private String initiatorName;

	@JsonProperty("SecurityCredential")
	private String securityCredential;

	@JsonProperty("Occassion")
	private String occassion;

	@JsonProperty("CommandID")
	private String commandID;

	@JsonProperty("PartyA")
	private String partyA;

	@JsonProperty("PartyB")
	private String partyB;

	@JsonProperty("ResultURL")
	private String resultURL;
}