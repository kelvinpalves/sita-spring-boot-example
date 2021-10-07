package br.com.forgeit.urbanobservatory.domain;

import br.com.forgeit.urbanobservatory.common.exception.InvalidSitaConfigurationException;

public enum SitaLevelEnum {

    NO_INFORMATION(0),
    AGGREGATION(1),
    OBFUSCATION(2),
    REGULATION(3),
    FULL_INFORMATION(4);

    private final Integer level;

    SitaLevelEnum(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public static SitaLevelEnum getLevelEnum(String levelStr) throws InvalidSitaConfigurationException {
        Integer level;
        try {
            level = Integer.parseInt(levelStr);
        } catch (Exception ex) {
            throw new InvalidSitaConfigurationException("The level must be a number. (Invalid: " + levelStr + ")");
        }

        for (SitaLevelEnum sitaLevelEnum : SitaLevelEnum.values()) {
            if (level.equals(sitaLevelEnum.level)) {
                return sitaLevelEnum;
            }
        }

        throw new InvalidSitaConfigurationException("Invalid: " + levelStr + "");
    }
}
