package com.tigo.EmInfrastructure.adapter;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.tigo.EmApplication.usecase.dto.DataOnDemandRequest;

@FeignClient(name = "dataOnDemand", url = "${external.api.rest.base-url}")
public interface DataOnDemandClient {

  @PostMapping("${external.api.rest.client.dataOnDemand}")
  @Headers("Content-Type: application/json")
  String postDataOnDemand(@RequestBody DataOnDemandRequest request,
      @RequestHeader("Authorization") String bearerToken);
}
