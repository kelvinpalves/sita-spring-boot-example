package br.com.forgeit.sita.usecase.provider.identity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class IdentityRegulationStrategy implements StrategyHandler<IdentityDataDto> {

    private List<String> regulationList = new ArrayList<>(Arrays.asList("Urban Sciences Building: Floor 6: Room 6.030"));

    @Override
    public IdentityDataDto execute(IdentityDataDto dto) {
        return IdentityDataDto.builder()
                .name(getName(dto.getName()))
                .entityId(getEntityId(dto.getName(), dto.getEntityId()))
                .build();
    }

    public String getName(String name) {
        return regulationList.contains(name) ? "Urban Sciences Building" : name;
    }

    public String getEntityId(String name, String entityId) {
        return regulationList.contains(name) ? "anonymous" : entityId;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.REGULATION;
    }

}
