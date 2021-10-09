package br.com.forgeit.sita.usecase.manager;

import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.*;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigDto;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigInputBoundary;
import br.com.forgeit.sita.usecase.provider.activity.ActivityProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.identity.IdentityProviderInputBoundary;
import br.com.forgeit.sita.usecase.provider.spatial.SpatialProviderInputBoundary;
import br.com.forgeit.urbanobservatory.usecase.getdata.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @Override
    public List<ResponseDto> applyRules(List<ResponseDto> originalDataList) {
        try {
            GetSitaConfigDto sitaConfigDto = getSitaConfig.getCurrent();

            log.info("Current sita-config: {}", sitaConfigDto);
            log.info("Original Data: ");
            originalDataList.forEach(log::info);

            List<GroupedDataDto> convertedDataList = new ArrayList<>();

            for (ResponseDto originalData : originalDataList) {
                convertedDataList.add(dataCenter.convertOriginalDataToGroupedData(originalData));
            }

            log.info("Converted Data: ");
            convertedDataList.forEach(log::info);

            SitaLevelEnum activityLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getActivityDataLevel().toString());
            SitaLevelEnum identityLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getIdentityDataLevel().toString());
            SitaLevelEnum spatialLevel = SitaLevelEnum.getLevelEnum(sitaConfigDto.getSpatialDataLevel().toString());

            for (int i = 0; i < convertedDataList.size(); i++) {
                List<MetricGroupedData> metrics = convertedDataList.get(i).getMetricsGroupedData();
                GroupedDataDto groupedDataDto = convertedDataList.get(i);
                IdentityDataDto identityDataDto = groupedDataDto.getIdentityDataDto();
                identityDataDto = identityProviderInputBoundary.convert(identityLevel, identityDataDto);
                convertedDataList.get(i).setIdentityDataDto(identityDataDto);

                SpatialDataDto spatialDataDto = groupedDataDto.getSpatialDataDto();
                spatialDataDto = spatialProviderInputBoundary.convert(spatialLevel, spatialDataDto);
                convertedDataList.get(i).setSpatialDataDto(spatialDataDto);

                for (int j = 0; j < metrics.size(); j++) {
                    ActivityDataDto dto = metrics.get(j).getActivityDataDto();
                    dto = activityProviderInputBoundary.convert(activityLevel, dto);
                    metrics.get(j).setActivityDataDto(dto);
                }
            }

            return ResponseDto.getFinalData(convertedDataList);
        } catch (Exception ex) {
            log.error(ex);
            return null;
        }
    }
}
