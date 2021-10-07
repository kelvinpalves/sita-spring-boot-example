package br.com.forgeit.urbanobservatory.usecase.registerconfig;

import br.com.forgeit.urbanobservatory.infra.rest.SitaConfigurationResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface RegisterSitaConfigurationInputBoundary {

    SitaConfigurationResponseDto setSitaConfig(String config);

}
