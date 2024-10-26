package com.jonnie.darajaapi.controllers;

import com.jonnie.darajaapi.dtos.*;
import com.jonnie.darajaapi.services.DarajaApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mobile-money")
@RequiredArgsConstructor
public class MpesaController {
    private final DarajaApi darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;

    @GetMapping(produces = "application/json", path = "token")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    @PostMapping(path = "register-url", produces = "application/json")
    public ResponseEntity<RegisterUrlResponse> registerUrl() {
        return ResponseEntity.ok(darajaApi.registerUrl());
    }

    @PostMapping(path = "validation-url", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> validationTransaction(@RequestBody TransactionResults transactionResults) {
        return ResponseEntity.ok(acknowledgeResponse);
    }

    @PostMapping(path = "simulate-c2b", produces = "application/json")
    public ResponseEntity<SimulateC2BResponse> simulateC2BTransaction(@RequestBody SimulateC2BRequest simulateC2BRequest) {
        return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateC2BRequest));
    }

    @PostMapping(path="b2c-transaction-result", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> b2cTransactionAsyncResults(@RequestBody B2cTransactionAsyncResponse b2cTransactionAsyncResponse){
        return ResponseEntity.ok(acknowledgeResponse);
    }
}
