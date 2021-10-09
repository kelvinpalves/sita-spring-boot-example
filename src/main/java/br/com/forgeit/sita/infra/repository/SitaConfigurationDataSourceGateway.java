package br.com.forgeit.sita.infra.repository;

import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigDto;
import br.com.forgeit.sita.usecase.registerconfig.SetSitaDto;
import org.springframework.stereotype.Component;

@Component
public interface SitaConfigurationDataSourceGateway {

    void setSita(SetSitaDto dto) throws Exception;

    GetSitaConfigDto getSitaConfig();

}
