package br.com.forgeit.sita.infra.rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SetSitaResponseDto {
    private final Boolean status;
    private final String message;
    private final String configuration;

    public static SetSitaResponseDto success(String message, String configuration) {
        return SetSitaResponseDto.create(Boolean.TRUE, message, configuration);
    }

    public static SetSitaResponseDto error(String message) {
        return SetSitaResponseDto.create(Boolean.FALSE, message, null);
    }

    private static SetSitaResponseDto create(Boolean status, String message, String configuraton) {
        return new SetSitaResponseDto(status, message, configuraton);
    }
}
