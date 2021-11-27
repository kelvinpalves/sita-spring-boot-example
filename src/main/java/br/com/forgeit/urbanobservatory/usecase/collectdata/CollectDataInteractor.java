package br.com.forgeit.urbanobservatory.usecase.collectdata;

import br.com.forgeit.urbanobservatory.domain.model.Room;
import br.com.forgeit.urbanobservatory.infra.client.DataCollectorClient;
import br.com.forgeit.urbanobservatory.infra.client.DataCollectorDto;
import br.com.forgeit.urbanobservatory.infra.datasource.MetricsDataSourceGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollectDataInteractor implements CollectDataInputBoundary {

    private final DataCollectorClient collectorClient;
    private final MetricsDataSourceGateway datasource;

    @Override
    public void execute() {
        log.info("use case collect data was called");

    }

    private void register(String entityID) {
        Optional<DataCollectorDto> dataCollectorDtoOptional = collectorClient.getLatest(entityID);

        if (dataCollectorDtoOptional.isPresent()) {
            DataCollectorDto dto = dataCollectorDtoOptional.get();
            Room entity = Room.dataCollectorDtoToRoom(dto);
            RegisterMetricsDto registerMetricsDto = RegisterMetricsDto.roomToRegisterMetricsDto(entity);
            datasource.create(registerMetricsDto);
        }
    }
}
