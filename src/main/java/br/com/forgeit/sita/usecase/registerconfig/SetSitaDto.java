package br.com.forgeit.sita.usecase.registerconfig;

import br.com.forgeit.sita.domain.SitaConfig;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SetSitaDto {
    private final Integer spatialDataLevel;
    private final Integer identityDataLevel;
    private final Integer temporalDataLevel;
    private final Integer activityDataLevel;

    public static SetSitaDto sitaConfigToSitaConfigurationRegisterDto(SitaConfig sitaConfig) {
        return SetSitaDto.builder()
                .spatialDataLevel(sitaConfig.getSpatialDataLevel().getLevel())
                .identityDataLevel(sitaConfig.getIdentityDataLevel().getLevel())
                .activityDataLevel(sitaConfig.getActivityDataLevel().getLevel())
                .temporalDataLevel(sitaConfig.getTemporalDataLevel().getLevel())
                .build();
    }
}
