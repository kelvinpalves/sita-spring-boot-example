package br.com.forgeit.sita.usecase.provider.identity;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.provider.activity.ActivityProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.activity.handlers.*;
import br.com.forgeit.sita.usecase.provider.identity.handlers.*;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdentityProviderInteractor implements IdentityProviderInputBoundary {
    private List<StrategyHandler<IdentityDataDto>> services = new ArrayList<>();

    public IdentityProviderInteractor() {
        services.add(new IdentityNoInformationStrategy());
        services.add(new IdentityAggregationStrategy());
        services.add(new IdentityObfuscationStrategy());
        services.add(new IdentityRegulationStrategy());
        services.add(new IdentityFullInformationStrategy());
    }

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
