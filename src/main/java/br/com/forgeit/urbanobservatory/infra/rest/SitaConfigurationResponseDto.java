package br.com.forgeit.urbanobservatory.infra.rest;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SitaConfigurationResponseDto {
    private final Boolean status;
    private final String message;
}
