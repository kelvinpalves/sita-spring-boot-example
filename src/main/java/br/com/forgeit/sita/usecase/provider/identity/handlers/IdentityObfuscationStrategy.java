package br.com.forgeit.sita.usecase.provider.identity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class IdentityObfuscationStrategy implements StrategyHandler<IdentityDataDto> {

    @Override
    public IdentityDataDto execute(IdentityDataDto dto) {
        return IdentityDataDto.builder()
                .entityId(getEntityId(dto.getEntityId()))
                .name(getName(dto.getName()))
                .build();
    }

    private String getName(String name) {
        String[] parts = name.split(":");
        StringBuilder newName = new StringBuilder();
        newName.append(parts[0]).append(":");

        String floor = parts[1].replace("Floor", "").trim();
        Integer floorInteger = Integer.parseInt(floor);
        floorInteger = floorInteger % 2 == 0 ? (floorInteger + 1) : (floorInteger - 1);
        floorInteger = floorInteger > 10 ? 10 : floorInteger;
        floorInteger = floorInteger < 0 ? 0 : floorInteger;

        newName.append(" Floor: ").append(floorInteger.toString());

        String room = parts[2].replace("Room", "").replace(".", "").trim();
        Integer roomInteger = Integer.parseInt(room);
        roomInteger = roomInteger + 15;
        List<String> prefixes = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Collections.shuffle(prefixes);

        newName.append(" Room: ").append(prefixes.get(0)).append(roomInteger.toString());

        return newName.toString();
    }

    private String getEntityId(String entityId) {
        List<String> parts =  new ArrayList<>(Arrays.asList(entityId.split("-")));
        Collections.shuffle(parts);
        StringBuilder newId = new StringBuilder();
        parts.forEach(part -> newId.append(part).append("-"));
        return newId.toString();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.OBFUSCATION;
    }

}
