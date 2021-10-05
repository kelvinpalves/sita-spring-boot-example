package br.com.forgeit.urbanobservatory.infra.client;

import br.com.forgeit.urbanobservatory.infra.client.model.EntityDto;
import br.com.forgeit.urbanobservatory.infra.client.model.FeedDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestTemplateDataCollectorClient implements DataCollectorClient {

    @Value("${config.dataCollector.url}")
    private String url;

    private final Metrics metrics;

    @Override
    public Optional<DataCollectorDto> getLatest(String id) {
        log.info("rest template - calling to: {} - {}", this.url, id);

        RestTemplate restTemplate = new RestTemplate();
        String fullUrl = getFullUrl(id);
        ResponseEntity<EntityDto> response = restTemplate.getForEntity(fullUrl, EntityDto.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.info("Entity: {}", response.getBody());
            DataCollectorDto dataCollectorDto = DataCollectorDto.createFromEntityDto(response.getBody());
            System.out.println(dataCollectorDto);
            List<FeedDto> feedList = response.getBody().getFeed();

            for (FeedDto feedDto : feedList) {
                if (metrics.getAllowed().contains(feedDto.getMetric())) {
                    dataCollectorDto.addMetric(feedDto);
                } else {
                    log.warn("Metric: {} will not be collected.", feedDto.getMetric());
                }
            }

            return Optional.of(dataCollectorDto);
        }

        return Optional.empty();
    }

    private String getFullUrl(String id) {
        return this.url + id;
    }

}
