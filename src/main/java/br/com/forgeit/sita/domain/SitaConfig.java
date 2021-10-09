package br.com.forgeit.sita.domain;

import br.com.forgeit.sita.exception.InvalidSitaConfigurationException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SitaConfig {

    private final SitaLevelEnum spatialDataLevel;
    private final SitaLevelEnum identityDataLevel;
    private final SitaLevelEnum temporalDataLevel;
    private final SitaLevelEnum activityDataLevel;

    public SitaConfig(String config) throws InvalidSitaConfigurationException {
        final Integer SPATIAL = 0, IDENTITY = 1, TEMPORAL = 2, ACTIVITY = 3;

        String[] levels = config.split("");

        if (levels.length != 4) {
            throw new InvalidSitaConfigurationException("You must provide the four required levels.");
        }

        this.spatialDataLevel = SitaLevelEnum.getLevelEnum(levels[SPATIAL]);
        this.identityDataLevel = SitaLevelEnum.getLevelEnum(levels[IDENTITY]);
        this.temporalDataLevel = SitaLevelEnum.getLevelEnum(levels[TEMPORAL]);
        this.activityDataLevel = SitaLevelEnum.getLevelEnum(levels[ACTIVITY]);
    }
}
