package br.com.forgeit.urbanobservatory.usecase.getdata;

import br.com.forgeit.urbanobservatory.infra.repository.MetricsDataSourceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetDataInteractor implements GetDataInputBoundary {

    private final MetricsDataSourceGateway metricsDataSourceGateway;

    @Override
    public List<ResponseDto> getLatest() {
        return metricsDataSourceGateway.getLatest();
    }
}
