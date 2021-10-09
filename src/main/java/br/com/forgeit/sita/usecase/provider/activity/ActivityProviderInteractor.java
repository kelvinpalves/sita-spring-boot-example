package br.com.forgeit.sita.usecase.provider.activity;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.provider.activity.handlers.*;
import br.com.forgeit.sita.usecase.strategy.StrategyHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActivityProviderInteractor implements ActivityProviderInputBoundary {

    private List<StrategyHandler<ActivityDataDto>> services = new ArrayList<>();

    public ActivityProviderInteractor() {
        services.add(new ActivityNoInformationStrategy());
        services.add(new ActivityAggregationStrategy());
        services.add(new ActivityObfuscationStrategy());
        services.add(new ActivityRegulationStrategy());
        services.add(new ActivityFullInformationStrategy());
    }

    @Override
    public ActivityDataDto convert(SitaLevelEnum level, ActivityDataDto activityDataDto) throws Exception {
        for (StrategyHandler<ActivityDataDto> service : services) {
            if (service.getSitaLevelEnum().equals(level)) {
                return service.execute(activityDataDto);
            }
        }

        throw new Exception("Invalid handler");
    }


}
