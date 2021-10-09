package br.com.forgeit.sita.usecase.provider.identity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class IdentityFullInformationStrategy implements StrategyHandler<IdentityDataDto> {
    @Override
    public IdentityDataDto execute(IdentityDataDto dto) {
        return dto;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.FULL_INFORMATION;
    }
}
