package br.com.forgeit.urbanobservatory.infra.repository;

import br.com.forgeit.urbanobservatory.usecase.collectdata.MetricsDto;
import br.com.forgeit.urbanobservatory.usecase.collectdata.RegisterMetricsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
