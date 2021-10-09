package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Builder
@Data
@ToString
public class GroupedDataDto {
    private SpatialDataDto spatialDataDto;
    private IdentityDataDto identityDataDto;
    private List<MetricGroupedData> metricsGroupedData;
}


