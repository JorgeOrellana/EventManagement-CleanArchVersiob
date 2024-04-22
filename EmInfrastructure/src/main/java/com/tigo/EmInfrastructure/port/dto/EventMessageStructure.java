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
public class EventMessageStructure {

  @JsonProperty
  private HeaderStructure header;
  @JsonProperty
  private EventStructure event;
}
