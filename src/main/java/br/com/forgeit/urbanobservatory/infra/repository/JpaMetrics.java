package br.com.forgeit.urbanobservatory.infra.repository;

import br.com.forgeit.urbanobservatory.usecase.collectdata.MetricsDto;
import br.com.forgeit.urbanobservatory.usecase.collectdata.RegisterMetricsDto;
import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log4j2
public class JpaMetrics implements MetricsDataSourceGateway {

    private final JpaMetricsRepository metricsRepository;
    private final JpaRoomRepository roomRepository;

    @Override
    @Transactional
    public void create(RegisterMetricsDto registerMetricsDto) {
        log.info("datasource was called: register dto - {}", registerMetricsDto);

        RoomDataMapper roomDataMapper = new RoomDataMapper();
        roomDataMapper.setId(registerMetricsDto.getEntityId());
        roomDataMapper.setName(registerMetricsDto.getName());
        roomDataMapper.setBuilding(registerMetricsDto.getBuilding());
        roomDataMapper.setCreatedAt(LocalDateTime.now());
        roomDataMapper.setRoomNumber(registerMetricsDto.getRoomNumber());
        roomDataMapper.setBuildingFloor(registerMetricsDto.getBuildingFloor());

        roomRepository.saveAndFlush(roomDataMapper);
        log.info("entity created: {}", roomDataMapper);

        registerMetricsDto.getMetrics().forEach(metric -> createMetrics(metric, roomDataMapper));
    }

    @Override
    public List<ResponseDto> getLatest() {
        List<RoomDataMapper> rooms = roomRepository.findAll();
        return rooms.stream().map(this::createResponseDto).collect(Collectors.toList());
    }

    private ResponseDto createResponseDto(RoomDataMapper room) {
        List<MetricDataMapper> metrics = metricsRepository.findLatestByEntity(room.getId());
        log.info("finding metrics from entity {}", room.getId());
        log.info("list: {}", metrics);
        List<Map<String, Object>> metricsMap = new ArrayList<>();

        metrics.stream().forEach(metric -> {
            Map<String, Object> data = new HashMap<>();
            data.put("lastUpdate", metric.getLastUpdate());
            data.put("unit", metric.getUnit());
            data.put("value", metric.getValue());
            metricsMap.add(data);
        });

        log.info("map: {}", metricsMap);

        return ResponseDto.builder()
                .entityId(room.getId())
                .name(room.getName())
                .buildingFloor(room.getBuildingFloor())
                .building(room.getBuilding())
                .roomNumber(room.getRoomNumber())
                .metrics(metricsMap)
                .build();
    }

    private void createMetrics(MetricsDto metric, RoomDataMapper roomDataMapper) {
        MetricDataMapper metricDataMapper = new MetricDataMapper();
        metricDataMapper.setCreatedAt(LocalDateTime.now());
        metricDataMapper.setEntity(roomDataMapper);
        metricDataMapper.setUnit(metric.getUnit());
        metricDataMapper.setLastUpdate(metric.getLastUpdate());
        metricDataMapper.setValue(metric.getValue());
        metricsRepository.saveAndFlush(metricDataMapper);
        log.info("metric created: {}", metricDataMapper);
    }
}
