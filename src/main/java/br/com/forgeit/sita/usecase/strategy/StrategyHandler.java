package br.com.forgeit.sita.usecase.strategy;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import org.springframework.stereotype.Component;

@Component
public interface StrategyHandler<T> {

    T execute(T dto) throws Exception;

    SitaLevelEnum getSitaLevelEnum();

}

