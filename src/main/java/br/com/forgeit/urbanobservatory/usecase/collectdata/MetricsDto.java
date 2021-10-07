package br.com.forgeit.urbanobservatory.usecase.collectdata;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class MetricsDto {

    private String name;
    private String unit;
    private LocalDateTime lastUpdate;
    private String value;

}
