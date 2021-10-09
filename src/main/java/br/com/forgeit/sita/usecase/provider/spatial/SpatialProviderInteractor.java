package br.com.forgeit.sita.usecase.provider.spatial;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpatialProviderInteractor implements SpatialProviderInputBoundary {

    private final List<StrategyHandler<SpatialDataDto>> services;

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

