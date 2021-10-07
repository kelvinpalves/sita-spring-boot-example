package br.com.forgeit.urbanobservatory.usecase.registerconfig;

import br.com.forgeit.urbanobservatory.common.exception.InvalidSitaConfigurationException;
import br.com.forgeit.urbanobservatory.domain.SitaConfig;
import br.com.forgeit.urbanobservatory.infra.rest.SitaConfigurationResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RegisterSitaConfigurationInteractor implements RegisterSitaConfigurationInputBoundary {

    @Override
    public SitaConfigurationResponseDto setSitaConfig(String config) {
        try {

            log.info("set-sita was called: trying {}", config);

            SitaConfig sitaConfig = new SitaConfig(config);

            log.info("string parsed to sita config: {}", sitaConfig);

            SitaConfigurationRegisterDto sitaConfigurationRegisterDto = SitaConfigurationRegisterDto.sitaConfigToSitaConfigurationRegisterDto(sitaConfig);



        } catch (InvalidSitaConfigurationException e) {
            log.error(e.getMessage());
        }

        return null;
    }

}
