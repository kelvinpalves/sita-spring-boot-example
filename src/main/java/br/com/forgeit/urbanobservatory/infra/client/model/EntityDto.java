package br.com.forgeit.urbanobservatory.infra.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class EntityDto {

    private String entityId;
    private String name;
    private Map<String, String> meta;
    private List<FeedDto> feed;

}
