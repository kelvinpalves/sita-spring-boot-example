package br.com.forgeit.sita.usecase.getconfig;

import br.com.forgeit.sita.infra.repository.SitaConfigurationDataSourceGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class GetSitaConfigInteractor implements GetSitaConfigInputBoundary {

    private final SitaConfigurationDataSourceGateway dataSourceGateway;

    @Override
    public GetSitaConfigDto getCurrent() {
        return dataSourceGateway.getSitaConfig();
    }
}
