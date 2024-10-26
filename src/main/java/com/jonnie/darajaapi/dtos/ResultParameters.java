package com.jonnie.darajaapi.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameters{

	@JsonProperty("ResultParameter")
	private List<ResultParameterItem> resultParameter;
}