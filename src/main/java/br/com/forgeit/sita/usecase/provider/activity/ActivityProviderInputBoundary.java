package br.com.forgeit.sita.usecase.provider.activity;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import org.springframework.stereotype.Component;

@Component
public interface ActivityProviderInputBoundary {

    ActivityDataDto convert(SitaLevelEnum level, ActivityDataDto activityDataDto) throws Exception;

}
