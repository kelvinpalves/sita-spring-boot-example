package br.com.forgeit.sita.usecase.registerconfig;

import br.com.forgeit.exception.InvalidSitaConfigurationException;
import br.com.forgeit.sita.domain.SitaConfig;
import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.infra.repository.SitaConfigurationDataSourceGateway;
import br.com.forgeit.sita.infra.rest.SetSitaResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class RegisterSitaConfigurationInteractor implements RegisterSitaConfigurationInputBoundary {

    private final SitaConfigurationDataSourceGateway dataSourceGateway;

    @Override
    public SetSitaResponseDto setSitaConfig(String config) {
        try {
            log.info("set-sita was called: trying {}", config);
            SitaConfig sitaConfig = new SitaConfig(config);
            log.info("string parsed to sita config: {}", sitaConfig);
            SetSitaDto setSitaDto = SetSitaDto.sitaConfigToSitaConfigurationRegisterDto(sitaConfig);
            dataSourceGateway.setSita(setSitaDto);
            return SetSitaResponseDto.success("The SITA's configurations were updated. ", this.getStringConfiguration(setSitaDto));
        } catch (InvalidSitaConfigurationException e) {
            log.error(e.getMessage());
            return SetSitaResponseDto.error(e.getMessage());
        } catch (Exception ex) {
            return SetSitaResponseDto.error("Error to update SITA's configurations.");
        }
    }

    private String getStringConfiguration(SetSitaDto setSitaDto) throws InvalidSitaConfigurationException {
        StringBuilder definedLevels = new StringBuilder();
        definedLevels.append("Spatial: ");
        definedLevels.append(SitaLevelEnum.getLevelEnum(String.valueOf(setSitaDto.getSpatialDataLevel())));
        definedLevels.append(" - ");
        definedLevels.append("Identity: ");
        definedLevels.append(SitaLevelEnum.getLevelEnum(String.valueOf(setSitaDto.getIdentityDataLevel())));
        definedLevels.append(" - ");
        definedLevels.append("Temporal: ");
        definedLevels.append(SitaLevelEnum.getLevelEnum(String.valueOf(setSitaDto.getTemporalDataLevel())));
        definedLevels.append(" - ");
        definedLevels.append("Activity: ");
        definedLevels.append(SitaLevelEnum.getLevelEnum(String.valueOf(setSitaDto.getActivityDataLevel())));
        return definedLevels.toString();
    }

}
