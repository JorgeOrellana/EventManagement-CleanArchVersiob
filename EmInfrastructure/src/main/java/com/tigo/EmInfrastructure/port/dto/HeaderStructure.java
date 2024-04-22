package com.tigo.EmInfrastructure.port.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeaderStructure {

  @JsonProperty
  private String eventId;
  @JsonProperty
  private String eventConsumptionTime;
  @JsonProperty
  private String timestamp;
}
