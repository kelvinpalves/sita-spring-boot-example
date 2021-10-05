package br.com.forgeit.urbanobservatory.usecase.collectdata;

import br.com.forgeit.urbanobservatory.infra.client.DataCollectorClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CollectDataInteractor implements CollectDataInputBoundary {

    private final DataCollectorClient collectorClient;
    private final Rooms rooms;

    @Override
    public void execute() {
        log.info("Collecting data from: {}", rooms.getConfigurations());

        rooms.getConfigurations().stream().forEach(room -> collectorClient.getLatest(room.getEntityID()));
    }
}
