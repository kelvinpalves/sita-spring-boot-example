package br.com.forgeit.sita.infra.rest;

import br.com.forgeit.sita.usecase.registerconfig.RegisterSitaConfigurationInputBoundary;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("admin/sita-manager/")
public class SitaConfigurationController {

    private final RegisterSitaConfigurationInputBoundary inputBoundary;

    @GetMapping("/set-sita/{config}")
    public SetSitaResponseDto setSitaConfig(@PathVariable String config) {
        return inputBoundary.setSitaConfig(config);
    }
}
