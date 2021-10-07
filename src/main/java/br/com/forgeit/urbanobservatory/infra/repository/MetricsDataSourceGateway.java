package br.com.forgeit.urbanobservatory.infra.repository;

import br.com.forgeit.urbanobservatory.usecase.collectdata.RegisterMetricsDto;
import org.springframework.stereotype.Component;

@Component
public interface MetricsDataSourceGateway {

    void create(RegisterMetricsDto registerMetricsDto);

}
