package com.tigo.EmInfrastructure.adapter;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DataOnDemandCredentials {

  @Value("${external.api.rest.auth.client-id}")
  private String clientId;
  @Value("${external.api.rest.auth.client-secret}")
  private String clientSecret;
  @Value("${external.api.rest.auth.grant-type}")
  private String grantType;

  public Map<String, String> credentials() {
    Map<String, String> mapData = new HashMap<>();
    mapData.put("client_id", clientId);
    mapData.put("client_secret", clientSecret);
    mapData.put("grant_type", grantType);

    return mapData;
  }
}