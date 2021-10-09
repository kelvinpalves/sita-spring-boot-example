package br.com.forgeit.urbanobservatory.usecase.getdata;

import br.com.forgeit.sita.usecase.datacenter.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Builder
@Getter
@ToString
public class ResponseDto {

    private String entityId;
    private String name;
    private String building;
    private Integer buildingFloor;
    private String roomNumber;
    private List<Map<String, Object>> metrics;

    public static List<ResponseDto> getFinalData(List<GroupedDataDto> list) {
        List<ResponseDto> responseDtoList = new ArrayList<>();

        for (GroupedDataDto groupedDataDto : list) {
            SpatialDataDto spatialDataDto = groupedDataDto.getSpatialDataDto();
            IdentityDataDto identityDataDto = groupedDataDto.getIdentityDataDto();
            List<MetricGroupedData> metricGroupedDataList = groupedDataDto.getMetricsGroupedData();
            List<Map<String, Object>> metricsList = new ArrayList<>();

            for (MetricGroupedData metricGroupedData : metricGroupedDataList) {
                ActivityDataDto activityDataDto = metricGroupedData.getActivityDataDto();
                TemporalDataDto temporalDataDto = metricGroupedData.getTemporalDataDto();
                Map<String, Object> map = new HashMap<>();
                map.put("lastUpdate", temporalDataDto.getLastUpdate());
                map.put("unit", activityDataDto.getUnit());
                map.put("value", activityDataDto.getValue());
                metricsList.add(map);
            }

            ResponseDto responseDto = ResponseDto.builder()
                    .building(spatialDataDto.getBuilding())
                    .buildingFloor(spatialDataDto.getBuildingFloor())
                    .roomNumber(spatialDataDto.getRoomNumber())
                    .entityId(identityDataDto.getEntityId())
                    .name(identityDataDto.getName())
                    .metrics(metricsList)
                    .build();

            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }



}
