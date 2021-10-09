package br.com.forgeit.urbanobservatory.usecase.getdata;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GetDataInputBoundary {

    List<ResponseDto> getLatest();

}
