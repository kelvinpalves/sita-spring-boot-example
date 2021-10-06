package br.com.forgeit.urbanobservatory.infra.client;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MetricDto {
    private final String name;
    private final String unit;
    private final String time;
    private final Double duration;
    private final String value;
}
