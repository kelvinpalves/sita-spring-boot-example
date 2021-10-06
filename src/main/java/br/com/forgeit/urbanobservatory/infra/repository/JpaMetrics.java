package br.com.forgeit.urbanobservatory.infra.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class JpaMetrics implements MetricsDataSourceGateway {

    private final JpaMetricsRepository metricsRepository;
    private final JpaRoomRepository roomRepository;

    @Override
    public void create(RegisterMetricsDto registerMetricsDto) {

    }
}
