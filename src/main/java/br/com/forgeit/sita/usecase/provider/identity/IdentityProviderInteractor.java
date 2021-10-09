package br.com.forgeit.sita.usecase.provider.identity;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IdentityProviderInteractor implements IdentityProviderInputBoundary {

    private final List<StrategyHandler<IdentityDataDto>> services;

    @Override
    public IdentityDataDto convert(SitaLevelEnum level, IdentityDataDto identityDataDto) throws Exception {
        for (StrategyHandler<IdentityDataDto> service : services) {
            if (service.getSitaLevelEnum().equals(level)) {
                return service.execute(identityDataDto);
            }
        }

        throw new Exception("Invalid handler");
    }
}
