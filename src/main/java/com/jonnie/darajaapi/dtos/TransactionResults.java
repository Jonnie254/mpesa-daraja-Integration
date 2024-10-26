package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionResults {
    @JsonProperty("TransactionType")
    private String transactionType;
    @JsonProperty("BillRefNumber")
    private String billRefNumber;
    @JsonProperty("MSISDN")
    private String mSISDN;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("MiddleName")
    private String middleName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;
    @JsonProperty("OrgAccountBalance")
    private String orgAccountBalance;
    @JsonProperty("TransAmount")
    private String transAmount;
    @JsonProperty("TransTime")
    private String transTime;
    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransID;
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("TransID")
    private String transID;
}
