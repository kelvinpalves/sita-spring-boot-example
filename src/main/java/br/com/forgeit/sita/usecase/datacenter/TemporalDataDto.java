package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class TemporalDataDto {
    private final LocalDateTime lastUpdate;
}
