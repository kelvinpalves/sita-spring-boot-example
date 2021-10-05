package br.com.forgeit.urbanobservatory.infra.client;

import lombok.Builder;

@Builder
public class MetricDto {
    private final String name;
    private final String unit;
    private final String time;
    private final Double duration;
    private final String value;
}
