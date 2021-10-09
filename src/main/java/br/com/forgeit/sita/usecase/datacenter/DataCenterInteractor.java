package br.com.forgeit.sita.usecase.datacenter;

import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataCenterInteractor implements DataCenterInputBoundary {
    @Override
    public GroupedDataDto convertOriginalDataToGroupedData(ResponseDto originalData) {
        return GroupedDataDto.builder()
                    .spatialDataDto(this.getSpatialData(originalData))
                    .identityDataDto(this.getIdentityData(originalData))
                    .metricsGroupedData(this.getMetricGroupedData(originalData))
                    .build();
    }

    private SpatialDataDto getSpatialData(ResponseDto originalData) {
        return SpatialDataDto.builder()
                .building(originalData.getBuilding())
                .buildingFloor(originalData.getBuildingFloor())
                .roomNumber(originalData.getRoomNumber())
                .build();
    }

    private IdentityDataDto getIdentityData(ResponseDto originalData) {
        return IdentityDataDto.builder()
                .entityId(originalData.getEntityId())
                .name(originalData.getName())
                .build();
    }

    private List<MetricGroupedData> getMetricGroupedData(ResponseDto originalData) {
        List<MetricGroupedData> metricGroupedData = new ArrayList<>();

        for (Map<String, Object> metric : originalData.getMetrics()) {
            metricGroupedData.add(
                    MetricGroupedData.builder()
                        .activityDataDto(getActivityData(metric))
                        .temporalDataDto(getTemporalData(metric))
                        .build());
        }

        return metricGroupedData;
    }

    private TemporalDataDto getTemporalData(Map<String, Object> metric) {
        return TemporalDataDto.builder()
                .lastUpdate(LocalDateTime.parse(metric.get("lastUpdate").toString()))
                .build();
    }

    private ActivityDataDto getActivityData(Map<String, Object> metric) {
        return ActivityDataDto.builder()
                .unit(metric.get("unit").toString())
                .value(metric.get("value").toString())
                .build();
    }
}
