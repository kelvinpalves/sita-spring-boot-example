package br.com.forgeit.sita.usecase.getconfig;

import org.springframework.stereotype.Component;

@Component
public interface GetSitaConfigInputBoundary {

    GetSitaConfigDto getCurrent();

}
