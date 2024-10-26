package com.jonnie.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameterItem{

	@JsonProperty("Value")
	private int value;

	@JsonProperty("Key")
	private String key;
}