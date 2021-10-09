package br.com.forgeit.sita.domain;

public enum SitaGroupEnum {

    SPATIAL(0),
    IDENTITY(1),
    TEMPORAL(2),
    ACTIVITY(3);

    private final Integer group;

    SitaGroupEnum(Integer group) {
        this.group = group;
    }

}
