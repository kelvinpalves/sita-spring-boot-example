package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LatestDto {
    private String time;
    private Double duration;
    private String value;
}
