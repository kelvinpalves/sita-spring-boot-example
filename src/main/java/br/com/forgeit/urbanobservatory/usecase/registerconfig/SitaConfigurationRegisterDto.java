package br.com.forgeit.urbanobservatory.usecase.registerconfig;

import br.com.forgeit.urbanobservatory.domain.SitaConfig;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SitaConfigurationRegisterDto {
    private final Integer spatialDataLevel;
    private final Integer identityDataLevel;
    private final Integer temporalDataLevel;
    private final Integer activityDataLevel;

    public static SitaConfigurationRegisterDto sitaConfigToSitaConfigurationRegisterDto(SitaConfig sitaConfig) {
        return SitaConfigurationRegisterDto.builder()
                .spatialDataLevel(sitaConfig.getSpatialDataLevel().getLevel())
                .identityDataLevel(sitaConfig.getIdentityDataLevel().getLevel())
                .activityDataLevel(sitaConfig.getActivityDataLevel().getLevel())
                .temporalDataLevel(sitaConfig.getTemporalDataLevel().getLevel())
                .build();
    }
}
