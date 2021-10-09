package br.com.forgeit.sita.usecase.provider.temporal;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import br.com.forgeit.sita.usecase.datacenter.TemporalDataDto;
import org.springframework.stereotype.Component;

@Component
public interface TemporalProviderInputBoundary {

    TemporalDataDto convert(SitaLevelEnum level, TemporalDataDto temporalDataDto) throws Exception;

}
