package br.com.forgeit.sita.usecase.provider.identity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class IdentityAggregationStrategy implements StrategyHandler<IdentityDataDto> {

    @Override
    public IdentityDataDto execute(IdentityDataDto dto) {
        return IdentityDataDto.builder()
                .entityId(getEntityId(dto.getEntityId()))
                .name("Urban Science's Building")
                .build();
    }

    public String getEntityId(String entityId) {
        return entityId.split("-")[0];
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.AGGREGATION;
    }

}
