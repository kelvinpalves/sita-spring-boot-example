package br.com.forgeit.urbanobservatory.domain;

import br.com.forgeit.urbanobservatory.infra.client.DataCollectorDto;
import br.com.forgeit.urbanobservatory.infra.client.MetricDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@ToString
public class Room {

    private String entityId;
    private String name;
    private String building;
    private Integer buildingFloor;
    private String roomNumber;
    private final List<Sensor> sensors = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public static Room dataCollectorDtoToRoom(DataCollectorDto dto) {
        RoomBuilder roomBuilder = Room.builder();

        roomBuilder.entityId(dto.getEntityID());
        roomBuilder.name(dto.getName());
        roomBuilder.building(dto.getBuildingName());
        roomBuilder.buildingFloor(Integer.parseInt(dto.getBuildingFloor()));
        roomBuilder.roomNumber(dto.getRoomNumber());

        Room room = roomBuilder.build();

        for (MetricDto metricDto : dto.getMetrics()) {
            Sensor sensor = new Sensor(metricDto.getName(),
                    metricDto.getUnit(),
                    metricDto.getTime(),
                    metricDto.getValue());
            room.addSensor(sensor);
        }

        return room;
    }

}
