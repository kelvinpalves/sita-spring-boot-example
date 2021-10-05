package br.com.forgeit.urbanobservatory.infra.client;

import br.com.forgeit.urbanobservatory.infra.client.model.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestTemplateDataCollectorClient implements DataCollectorClient {

    @Value("${config.dataCollector.url}")
    private String url;

    @Override
    public DataCollectorDto getLatest(String id) {
        log.info("rest template - calling to: {} - {}", this.url, id);

        RestTemplate restTemplate = new RestTemplate();
        String fullUrl = getFullUrl(id);

        ResponseEntity<Entity> response = restTemplate.getForEntity(fullUrl, Entity.class);

        if (response.getStatusCode().equals(HttpStatus.OK)) {
            log.info("Entity: {}", response.getBody());
        }

        return null;
    }

    private String getFullUrl(String id) {
        return this.url + id;
    }

}
