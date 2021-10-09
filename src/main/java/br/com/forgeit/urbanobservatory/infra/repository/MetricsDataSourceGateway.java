package br.com.forgeit.urbanobservatory.infra.repository;

import br.com.forgeit.urbanobservatory.usecase.collectdata.RegisterMetricsDto;
import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetricsDataSourceGateway {

    void create(RegisterMetricsDto registerMetricsDto);

    List<ResponseDto> getLatest();

}
