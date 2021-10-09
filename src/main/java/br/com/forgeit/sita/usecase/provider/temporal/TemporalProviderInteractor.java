package br.com.forgeit.sita.usecase.provider.temporal;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.provider.temporal.handlers.*;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemporalProviderInteractor implements TemporalProviderInputBoundary {

    private List<StrategyHandler<TemporalDataDto>> services = new ArrayList<>();

    public TemporalProviderInteractor() {
        services.add(new TemporalNoInformationStrategy());
        services.add(new TemporalAggregationStrategy());
        services.add(new TemporalObfuscationStrategy());
        services.add(new TemporalRegulationStrategy());
        services.add(new TemporalFullInformationStrategy());
    }

    @Override
    public TemporalDataDto convert(SitaLevelEnum level, TemporalDataDto temporalDataDto) throws Exception {
        for (StrategyHandler<TemporalDataDto> service : services) {
            if (service.getSitaLevelEnum().equals(level)) {
                return service.execute(temporalDataDto);
            }
        }

        throw new Exception("Invalid handler");
    }
}
