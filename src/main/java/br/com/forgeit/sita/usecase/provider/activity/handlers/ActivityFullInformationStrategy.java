package br.com.forgeit.sita.usecase.provider.activity.handlers;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

@Component
public class ActivityFullInformationStrategy implements StrategyHandler<ActivityDataDto> {

    @Override
    public ActivityDataDto execute(ActivityDataDto dto) {
        return dto;
    }

    public String getUnit() {
        return "weather";
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.FULL_INFORMATION;
    }

}
