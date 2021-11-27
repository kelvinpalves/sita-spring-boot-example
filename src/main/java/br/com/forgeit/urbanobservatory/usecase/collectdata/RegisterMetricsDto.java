package br.com.forgeit.urbanobservatory.usecase.collectdata;

import br.com.forgeit.urbanobservatory.domain.model.Room;
import br.com.forgeit.urbanobservatory.domain.model.Sensor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@ToString
public class RegisterMetricsDto {
    private String entityId;
    private String name;
    private String building;
    private Integer buildingFloor;
    private String roomNumber;
    private final List<MetricsDto> metrics = new ArrayList<>();

    private void addMetric(MetricsDto dto) {
        this.metrics.add(dto);
    }

    public static RegisterMetricsDto roomToRegisterMetricsDto(Room room) {
        RegisterMetricsDtoBuilder registerMetricsDtoBuilder = RegisterMetricsDto.builder();
        registerMetricsDtoBuilder
                .entityId(room.getEntityId())
                .building(room.getBuilding())
                .buildingFloor(room.getBuildingFloor())
                .roomNumber(room.getRoomNumber())
                .name(room.getName());

        RegisterMetricsDto dto = registerMetricsDtoBuilder.build();
        for (Sensor sensor : room.getSensors()) {
            dto.addMetric(MetricsDto.builder()
                    .name(sensor.getMetricName())
                    .lastUpdate(sensor.getLastUpdate())
                    .unit(sensor.getUnitName())
                    .value(sensor.getValue())
                    .build());
        }

        return dto;
    }

}
