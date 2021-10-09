package br.com.forgeit.sita.usecase.provider.spatial.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class SpatialObfuscationStrategy implements StrategyHandler<SpatialDataDto> {

    @Override
    public SpatialDataDto execute(SpatialDataDto dto) {
        return SpatialDataDto.builder()
                .building(getBuilding(dto.getBuilding()))
                .buildingFloor(getBuildingFloor(dto.getBuildingFloor()))
                .roomNumber(getRoomNumber(dto.getRoomNumber()))
                .build();
    }

    private String getRoomNumber(String room) {
        room = room.replace(".", "");
        List<String> numbers = new ArrayList<>(Arrays.asList(room.split("")));
        Collections.shuffle(numbers);
        return numbers.stream().reduce("", String::concat);
    }

    private Integer getBuildingFloor(Integer floor) {
        return floor - 33;
    }

    private String getBuilding(String building) {
        List<String> departments = new ArrayList<>(Arrays.asList("History", "Engineering", "Languages", "Architecture", "Literature"));
        Collections.shuffle(departments);
        String fakeBuilding = "Urban " + departments.get(0) + " Building";
        List<String> newDepartments = new ArrayList<>(Arrays.asList(fakeBuilding, building));
        Collections.shuffle(newDepartments);
        return newDepartments.toString();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.OBFUSCATION;
    }

}
