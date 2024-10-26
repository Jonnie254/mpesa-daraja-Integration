package com.jonnie.darajaapi.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonnie.darajaapi.dtos.AcknowledgeResponse;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public AcknowledgeResponse acknowledgeResponse() {
        AcknowledgeResponse acknowledgeResponse = new AcknowledgeResponse();
        acknowledgeResponse.setMessage("Success");
        return acknowledgeResponse;
    }
}
