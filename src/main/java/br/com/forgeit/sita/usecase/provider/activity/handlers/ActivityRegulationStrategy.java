package br.com.forgeit.sita.usecase.provider.activity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ActivityRegulationStrategy implements StrategyHandler<ActivityDataDto> {

    private List<String> regulationList = new ArrayList<>(Arrays.asList("degrees celsius"));

    @Override
    public ActivityDataDto execute(ActivityDataDto dto) {
        return ActivityDataDto.builder()
                .unit(getUnit(dto.getUnit()))
                .value(dto.getValue())
                .build();
    }

    public String getUnit(String unit) {
        return regulationList.contains(unit) ? "wheater" : unit;
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.REGULATION;
    }

}
