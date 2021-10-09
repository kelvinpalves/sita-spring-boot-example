package br.com.forgeit.sita.usecase.provider.identity;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.IdentityDataDto;
import org.springframework.stereotype.Component;

@Component
public interface IdentityProviderInputBoundary {

    IdentityDataDto convert(SitaLevelEnum level, IdentityDataDto IdentityDataDto) throws Exception;

}
