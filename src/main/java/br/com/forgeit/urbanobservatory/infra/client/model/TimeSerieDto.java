package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class TimeSerieDto {
    private Map<String, String> unit;
    private LatestDto latest;
}
