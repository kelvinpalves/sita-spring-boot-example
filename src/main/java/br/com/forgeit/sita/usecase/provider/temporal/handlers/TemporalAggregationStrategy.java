package br.com.forgeit.sita.usecase.provider.temporal.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class TemporalAggregationStrategy implements StrategyHandler<TemporalDataDto> {

    @Override
    public TemporalDataDto execute(TemporalDataDto dto) {
        return TemporalDataDto.builder()
                .lastUpdate(getLastUpdate(dto.getLastUpdate()))
                .build();
    }

    private LocalDateTime getLastUpdate(LocalDateTime lastUpdate) {
        return lastUpdate.truncatedTo(ChronoUnit.DAYS);
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.AGGREGATION;
    }

}
