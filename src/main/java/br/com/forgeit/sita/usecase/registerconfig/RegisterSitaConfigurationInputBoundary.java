package br.com.forgeit.sita.usecase.registerconfig;

import br.com.forgeit.sita.infra.rest.SetSitaResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface RegisterSitaConfigurationInputBoundary {

    SetSitaResponseDto setSitaConfig(String config);

}
