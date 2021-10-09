package br.com.forgeit.sita.usecase.provider.spatial.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class SpatialRegulationStrategy implements StrategyHandler<SpatialDataDto> {

    private static final String REGULATION = "6.030";

    @Override
    public SpatialDataDto execute(SpatialDataDto dto) {
        return SpatialDataDto.builder()
                .roomNumber(getRoomNumber(dto.getRoomNumber()))
                .buildingFloor(getBuildingFloor(dto.getRoomNumber(), dto.getBuildingFloor()))
                .building(getBuilding(dto.getRoomNumber(), dto.getBuilding()))
                .build();
    }

    public String getRoomNumber(String room) {
        return REGULATION.equals(room) ? "0.000" : room;
    }

    public String getBuilding(String room, String entityId) {
        return REGULATION.equals(room) ? "anonymous" : entityId;
    }

    public Integer getBuildingFloor(String room, Integer floor) {
        return REGULATION.equals(room) ? 0 : floor;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.REGULATION;
    }

}
