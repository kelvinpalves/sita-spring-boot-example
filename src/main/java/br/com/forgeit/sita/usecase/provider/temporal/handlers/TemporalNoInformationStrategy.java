package br.com.forgeit.sita.usecase.provider.temporal.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;

public class TemporalNoInformationStrategy implements StrategyHandler<TemporalDataDto> {

    @Override
    public TemporalDataDto execute(TemporalDataDto dto) {
        return TemporalDataDto.builder()
                .lastUpdate(null)
                .build();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.NO_INFORMATION;
    }

}
