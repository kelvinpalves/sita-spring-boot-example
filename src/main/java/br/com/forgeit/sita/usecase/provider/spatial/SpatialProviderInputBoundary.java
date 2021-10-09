package br.com.forgeit.sita.usecase.provider.spatial;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.SpatialDataDto;
import org.springframework.stereotype.Component;

@Component
public interface SpatialProviderInputBoundary {

    SpatialDataDto convert(SitaLevelEnum level, SpatialDataDto spatialDataDto) throws Exception;

}
