package br.com.forgeit.urbanobservatory.infra.repository;

import org.springframework.stereotype.Component;

@Component
public interface MetricsDataSourceGateway {

    void create(RegisterMetricsDto registerMetricsDto);

}
