package br.com.forgeit.urbanobservatory.infra.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("metrics")
@Data
public class Metrics {
    private List<String> allowed;
}
