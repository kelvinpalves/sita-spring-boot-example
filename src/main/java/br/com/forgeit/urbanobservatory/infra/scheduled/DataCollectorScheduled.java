package br.com.forgeit.urbanobservatory.infra.scheduled;

import br.com.forgeit.urbanobservatory.usecase.collectdata.CollectDataInputBoundary;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DataCollectorScheduled {

    private final CollectDataInputBoundary collectData;

    @Scheduled(fixedRate = 300000)
    public void getData() {
        log.info("collecting data from urban repository");
        collectData.execute();
    }

}
