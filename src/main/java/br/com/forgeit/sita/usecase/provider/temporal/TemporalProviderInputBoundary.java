package br.com.forgeit.sita.usecase.provider.temporal;

import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import org.springframework.stereotype.Component;

@Component
public interface TemporalProviderInputBoundary {

    TemporalDataDto convert(TemporalDataDto temporalDataDto);

}
