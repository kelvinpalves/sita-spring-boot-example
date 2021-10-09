package br.com.forgeit.sita.usecase.provider.activity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class ActivityObfuscationStrategy implements StrategyHandler<ActivityDataDto> {

    private List<String> fakeUnit;

    @Override
    public ActivityDataDto execute(ActivityDataDto dto) {
        return ActivityDataDto.builder()
                .unit(getUnit(dto.getUnit()))
                .value(dto.getValue())
                .build();
    }

    public String getUnit(String unit) {
        fakeUnit = new ArrayList<>(Arrays.asList("precipitation", "wind", "fake_info01", "fake_info02"));
        Collections.shuffle(fakeUnit);
        int randomSeriesLength = 2;
        List<String> random = fakeUnit.subList(0, randomSeriesLength);
        random.add(unit);
        Collections.shuffle(random);
        return random.toString();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.OBFUSCATION;
    }

}
