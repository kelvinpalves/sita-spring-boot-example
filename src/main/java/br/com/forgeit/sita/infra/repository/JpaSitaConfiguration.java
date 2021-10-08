package br.com.forgeit.sita.infra.repository;

import br.com.forgeit.sita.usecase.registerconfig.SetSitaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class JpaSitaConfiguration implements SitaConfigurationDataSourceGateway {

    private final JpaSitaConfigurationRepository jpaSitaConfigurationRepository;
    private final Integer ID_CONFIG = 1;

    @Override
    public void setSita(SetSitaDto dto) throws Exception {
        try {
            SitaConfigurationDataMapper sitaConfigurationDataMapper = new SitaConfigurationDataMapper();
            sitaConfigurationDataMapper.setId(ID_CONFIG);
            sitaConfigurationDataMapper.setActivity(dto.getActivityDataLevel());
            sitaConfigurationDataMapper.setSpatial(dto.getSpatialDataLevel());
            sitaConfigurationDataMapper.setIdentity(dto.getIdentityDataLevel());
            sitaConfigurationDataMapper.setTemporal(dto.getTemporalDataLevel());
            jpaSitaConfigurationRepository.saveAndFlush(sitaConfigurationDataMapper);
        } catch (Exception ex) {
            log.error(ex);
            throw new Exception("Error to save SITA configuration on database.");
        }
    }

}
