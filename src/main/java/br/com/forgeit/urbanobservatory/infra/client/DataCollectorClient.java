package br.com.forgeit.urbanobservatory.infra.client;

import org.springframework.stereotype.Service;

@Service
public interface DataCollectorClient {

    DataCollectorDto getLatest(String id);

}
