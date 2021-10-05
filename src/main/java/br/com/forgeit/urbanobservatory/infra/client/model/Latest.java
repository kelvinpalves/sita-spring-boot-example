package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Latest {
    private String time;
    private Double duration;
    private Integer value;
}
