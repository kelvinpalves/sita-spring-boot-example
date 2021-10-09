package br.com.forgeit.sita.usecase.provider.temporal;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TemporalProviderInteractor implements TemporalProviderInputBoundary {

    private final List<StrategyHandler<TemporalDataDto>> services;

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


