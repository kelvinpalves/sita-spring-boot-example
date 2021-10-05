package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class FeedDto {
    private String metric;
    private List<TimeSerieDto> timeseries;
}
