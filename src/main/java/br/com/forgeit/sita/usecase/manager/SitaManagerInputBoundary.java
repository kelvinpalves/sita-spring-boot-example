package br.com.forgeit.sita.usecase.manager;

import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SitaManagerInputBoundary {

    List<ResponseDto> applyRules(List<ResponseDto> originalData);

}
