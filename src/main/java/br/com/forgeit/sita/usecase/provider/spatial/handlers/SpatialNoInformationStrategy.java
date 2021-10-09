package br.com.forgeit.sita.usecase.provider.spatial.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class SpatialNoInformationStrategy implements StrategyHandler<SpatialDataDto> {

    @Override
    public SpatialDataDto execute(SpatialDataDto dto) {
        return SpatialDataDto.builder()
                .building("")
                .buildingFloor(0)
                .roomNumber("")
                .build();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.NO_INFORMATION;
    }

}
