package br.com.forgeit.sita.usecase.provider.temporal.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class TemporalFullInformationStrategy implements StrategyHandler<TemporalDataDto> {
    @Override
    public TemporalDataDto execute(TemporalDataDto dto) {
        return dto;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.FULL_INFORMATION;
    }
}


