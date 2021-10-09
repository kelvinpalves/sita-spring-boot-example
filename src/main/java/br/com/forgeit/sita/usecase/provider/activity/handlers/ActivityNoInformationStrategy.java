package br.com.forgeit.sita.usecase.provider.activity.handlers;

import br.com.forgeit.sita.domain.SitaGroupEnum;
import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;

public class ActivityNoInformationStrategy implements StrategyHandler<ActivityDataDto> {

    @Override
    public ActivityDataDto execute(ActivityDataDto dto) {
        return ActivityDataDto.builder()
                .unit("")
                .value(dto.getValue())
                .build();
    }

    @Override
    public SitaLevelEnum getSitaLevelEnum() {
        return SitaLevelEnum.NO_INFORMATION;
    }

}
