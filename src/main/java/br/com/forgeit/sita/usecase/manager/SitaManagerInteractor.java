package br.com.forgeit.sita.usecase.manager;

import br.com.forgeit.exception.InvalidSitaConfigurationException;
import br.com.forgeit.sita.domain.SitaLevelEnum;
import br.com.forgeit.sita.usecase.datacenter.ActivityDataDto;
import br.com.forgeit.sita.usecase.datacenter.DataCenterInputBoundary;
import br.com.forgeit.sita.usecase.datacenter.GroupedDataDto;
import br.com.forgeit.sita.usecase.datacenter.MetricGroupedData;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigDto;
import br.com.forgeit.sita.usecase.getconfig.GetSitaConfigInputBoundary;
import br.com.forgeit.sita.usecase.provider.activity.ActivityProviderInputBoundary;
import br.com.forgeit.urbanobservatory.usecase.getdata.GetDataInputBoundary;
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

            for (int i = 0; i < convertedDataList.size(); i++) {
                List<MetricGroupedData> metrics = convertedDataList.get(i).getMetricsGroupedData();

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
