package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class TimeSerie {
    private Map<String, String> unit;
    private Latest latest;
}
