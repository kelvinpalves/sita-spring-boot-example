package br.com.forgeit.sita.usecase.provider.spatial;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.provider.identity.handlers.*;
import br.com.forgeit.sita.usecase.provider.spatial.handlers.*;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpatialProviderInteractor implements SpatialProviderInputBoundary {

    private List<StrategyHandler<SpatialDataDto>> services = new ArrayList<>();

    public SpatialProviderInteractor() {
        services.add(new SpatialNoInformationStrategy());
        services.add(new SpatialAggregationStrategy());
        services.add(new SpatialObfuscationStrategy());
        services.add(new SpatialRegulationStrategy());
        services.add(new SpatialFullInformationStrategy());
    }

    @Override
    public SpatialDataDto convert(SitaLevelEnum level, SpatialDataDto spatialDataDto) throws Exception {
        for (StrategyHandler<SpatialDataDto> service : services) {
            if (service.getSitaLevelEnum().equals(level)) {
                return service.execute(spatialDataDto);
            }
        }

        throw new Exception("Invalid handler");
    }
}
