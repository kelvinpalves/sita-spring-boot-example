package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ActivityDataDto {
    private final String value;
    private final String unit;
}
