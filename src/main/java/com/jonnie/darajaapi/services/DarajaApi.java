package com.jonnie.darajaapi.services;

import com.jonnie.darajaapi.dtos.AccessTokenResponse;
import com.jonnie.darajaapi.dtos.RegisterUrlResponse;
import com.jonnie.darajaapi.dtos.SimulateC2BRequest;
import com.jonnie.darajaapi.dtos.SimulateC2BResponse;


public interface DarajaApi {
    AccessTokenResponse getAccessToken();
    RegisterUrlResponse registerUrl();
    SimulateC2BResponse simulateC2BTransaction(SimulateC2BRequest simulateC2BRequest);
}
