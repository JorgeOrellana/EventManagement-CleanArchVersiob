package com.tigo.EmInfrastructure.adapter;

import feign.Headers;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dataOnDemandAuth", url = "${external.api.rest.base-url}")
public interface DataOnDemandAuthClient {

  @PostMapping("/dataOndemand/oauth2/token")
  @Headers("Content-Type: application/json")
  String authenticateDataOnDemand(@RequestBody Map<String, String> request);
}
