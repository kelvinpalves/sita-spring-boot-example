package br.com.forgeit.sita.usecase.provider.spatial.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class SpatialAggregationStrategy implements StrategyHandler<SpatialDataDto> {

    @Override
    public SpatialDataDto execute(SpatialDataDto dto) {
        return SpatialDataDto.builder()
                .building("Building")
                .buildingFloor(dto.getBuildingFloor() + 1)
                .roomNumber(dto.getRoomNumber().substring(0, dto.getRoomNumber().length() - 1) + "A")
                .build();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.AGGREGATION;
    }

}
