package br.com.forgeit.urbanobservatory.infra.client;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DataCollectorClient {

    Optional<DataCollectorDto> getLatest(String id);

}
