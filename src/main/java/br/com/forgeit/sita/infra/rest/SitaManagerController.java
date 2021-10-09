package br.com.forgeit.sita.infra.rest;

import br.com.forgeit.sita.usecase.manager.SitaManagerInputBoundary;
import br.com.forgeit.urbanobservatory.usecase.getdata.GetDataInputBoundary;
import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("admin/sita-manager/")
public class SitaManagerController {

    private final SitaManagerInputBoundary sitaManager;
    private final GetDataInputBoundary findDataService;


    @GetMapping("get-data")
    public List<ResponseDto> getData() {
        return sitaManager.applyRules(findDataService.getLatest());
    }

}
