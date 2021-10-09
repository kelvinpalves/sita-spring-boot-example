package br.com.forgeit.sita.usecase.datacenter;


import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface DataCenterInputBoundary {

    GroupedDataDto convertOriginalDataToGroupedData(ResponseDto originalData);

}
