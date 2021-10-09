package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class GroupedDataDto {
    private SpatialDataDto spatialDataDto;
    private IdentityDataDto identityDataDto;
    private List<MetricGroupedData> metricsGroupedData;
}


