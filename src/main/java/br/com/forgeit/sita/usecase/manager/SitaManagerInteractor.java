package br.com.forgeit.sita.usecase.manager;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.*;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigDto;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigInputBoundary;
import br.com.forgeit.sita.usecase.provider.activity.ActivityProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.identity.IdentityProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.spatial.SpatialProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.temporal.TemporalProviderInputBoundary;
import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class SitaManagerInteractor implements SitaManagerInputBoundary {

    private final GetSitaConfigInputBoundary getSitaConfig;
    private final DataCenterInputBoundary dataCenter;
    private final ActivityProviderInputBoundary activityProviderInputBoundary;
    private final IdentityProviderInputBoundary identityProviderInputBoundary;
    private final SpatialProviderInputBoundary spatialProviderInputBoundary;
    private final TemporalProviderInputBoundary temporalProviderInputBoundary;

    @Override
    public List<ResponseDto> applyRules(List<ResponseDto> originalDataList) {
        try {
            GetSitaConfigDto sitaConfigDto = getSitaConfig.getCurrent();
            List<GroupedDataDto> convertedDataList = new ArrayList<>();

            for (ResponseDto originalData : originalDataList) {
                convertedDataList.add(dataCenter.convertOriginalDataToGroupedData(originalData));
            }

            SitaLevelEnum activityLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getActivityDataLevel().toString());
            SitaLevelEnum identityLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getIdentityDataLevel().toString());
            SitaLevelEnum spatialLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getSpatialDataLevel().toString());
            SitaLevelEnum temporalLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getTemporalDataLevel().toString());

            for (GroupedDataDto groupedDataDto : convertedDataList) {
                List<MetricGroupedData> metrics = groupedDataDto.getMetricsGroupedData();
                groupedDataDto.setIdentityDataDto(identityProviderInputBoundary.convert(identityLevel, groupedDataDto.getIdentityDataDto()));
                groupedDataDto.setSpatialDataDto(spatialProviderInputBoundary.convert(spatialLevel, groupedDataDto.getSpatialDataDto()));

                for (MetricGroupedData metric : metrics) {
                    metric.setActivityDataDto(activityProviderInputBoundary.convert(activityLevel, metric.getActivityDataDto()));
                    metric.setTemporalDataDto(temporalProviderInputBoundary.convert(temporalLevel, metric.getTemporalDataDto()));
                }
            }

            return ResponseDto.getFinalData(convertedDataList);
        } catch (Exception ex) {
            log.error(ex);
            return Collections.emptyList();
        }
    }
}
