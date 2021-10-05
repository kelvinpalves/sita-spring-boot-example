package br.com.forgeit.urbanobservatory.usecase.collectdata;

import br.com.forgeit.urbanobservatory.infra.client.DataCollectorClient;
import br.com.forgeit.urbanobservatory.infra.client.DataCollectorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollectDataInteractor implements CollectDataInputBoundary {

    private final DataCollectorClient collectorClient;
    private final Rooms rooms;

    @Override
    public void execute() {
        log.info("use case collect data was called");
        rooms.getConfigurations().stream().forEach(this::register);
    }

    private void register(Rooms.Room room) {
        Optional<DataCollectorDto> dataCollectorDtoOptional = collectorClient.getLatest(room.getEntityID());

        log.info(dataCollectorDtoOptional);
    }
}
