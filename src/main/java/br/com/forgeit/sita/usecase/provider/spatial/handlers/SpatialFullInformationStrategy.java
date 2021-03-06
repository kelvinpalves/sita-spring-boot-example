package br.com.forgeit.sita.usecase.provider.spatial.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class SpatialFullInformationStrategy implements StrategyHandler<SpatialDataDto> {
    @Override
    public SpatialDataDto execute(SpatialDataDto dto) {
        return dto;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.FULL_INFORMATION;
    }
}


