package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.ToString;

import java.util.Map;

@ToString
public class TimeSerie {
    private Map<String, String> unit;
    private Latest latest;
}
