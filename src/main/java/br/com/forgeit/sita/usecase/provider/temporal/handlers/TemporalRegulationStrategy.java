package br.com.forgeit.sita.usecase.provider.temporal.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Component
public class TemporalRegulationStrategy implements StrategyHandler<TemporalDataDto> {

    @Override
    public TemporalDataDto execute(TemporalDataDto dto) {
        return TemporalDataDto.builder()
                .lastUpdate(getLastUpdate(dto.getLastUpdate()))
                .build();
    }

    private LocalDateTime getLastUpdate(LocalDateTime lastUpdate) {
        LocalTime lastTime = LocalTime.from(lastUpdate);

        LocalTime initial = LocalTime.of(8, 00,00);
        LocalTime finish = LocalTime.of(12, 30,00);

        if (lastTime.isAfter(initial) && lastTime.isBefore(finish)) {
            return lastUpdate.truncatedTo(ChronoUnit.DAYS);
        } else {
            return lastUpdate;
        }

    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.REGULATION;
    }

}
