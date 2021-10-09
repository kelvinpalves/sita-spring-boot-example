package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SpatialDataDto {
    private final String building;
    private final Integer buildingFloor;
    private final String roomNumber;
}
