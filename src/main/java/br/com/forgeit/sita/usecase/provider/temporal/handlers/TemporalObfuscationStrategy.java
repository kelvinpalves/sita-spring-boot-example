package br.com.forgeit.sita.usecase.provider.temporal.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class TemporalObfuscationStrategy implements StrategyHandler<TemporalDataDto> {

    @Override
    public TemporalDataDto execute(TemporalDataDto dto) {
        return TemporalDataDto.builder()
                .lastUpdate(getLastUpdate(dto.getLastUpdate()))
                .build();
    }

    private LocalDateTime getLastUpdate(LocalDateTime lastUpdate) {
        return lastUpdate.plusHours(3);
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.OBFUSCATION;
    }

}
