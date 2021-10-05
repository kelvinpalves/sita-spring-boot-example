package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Feed {
    private String metric;
    private List<TimeSerie> timeseries;
}
