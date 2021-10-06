package br.com.forgeit.urbanobservatory.infra.client;

import br.com.forgeit.urbanobservatory.infra.client.model.EntityDto;
import br.com.forgeit.urbanobservatory.infra.client.model.FeedDto;
import br.com.forgeit.urbanobservatory.infra.client.model.LatestDto;
import br.com.forgeit.urbanobservatory.infra.client.model.TimeSerieDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
@Log4j2
@Getter
public class DataCollectorDto {

    private final String entityID;
    private final String name;
    private final String buildingName;
    private final String roomNumber;
    private final String buildingFloor;
    private final List<MetricDto> metrics;

    public static DataCollectorDto createFromEntityDto(EntityDto dto) {
        return DataCollectorDto.builder()
                .entityID(dto.getEntityId())
                .name(dto.getName())
                .buildingName(dto.getMeta().get("building"))
                .roomNumber(dto.getMeta().get("roomNumber"))
                .buildingFloor(dto.getMeta().get("buildingFloor"))
                .metrics(new ArrayList<>())
                .build();
    }

    public void addMetric(FeedDto dto) {
        log.info("Metric: {}", dto);

        TimeSerieDto timeSerieDto = dto.getTimeseries().get(0);
        LatestDto latestDto = timeSerieDto.getLatest();

        MetricDto metricDto = MetricDto.builder()
                .name(dto.getMetric())
                .unit(timeSerieDto.getUnit().get("name"))
                .time(latestDto.getTime())
                .duration(latestDto.getDuration())
                .value(latestDto.getValue())
                .build();

        this.metrics.add(metricDto);
    }

}
