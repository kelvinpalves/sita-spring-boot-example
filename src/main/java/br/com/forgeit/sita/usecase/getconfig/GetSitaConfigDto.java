package br.com.forgeit.sita.usecase.getconfig;

import br.com.forgeit.sita.infra.repository.SitaConfigurationDataMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class GetSitaConfigDto {
    private final Integer spatialDataLevel;
    private final Integer identityDataLevel;
    private final Integer temporalDataLevel;
    private final Integer activityDataLevel;

    public static GetSitaConfigDto sitaConfigurationDataMapperToGetSitaConfigDto(SitaConfigurationDataMapper dataMapper) {
        return GetSitaConfigDto.builder()
                .activityDataLevel(dataMapper.getActivity())
                .identityDataLevel(dataMapper.getIdentity())
                .spatialDataLevel(dataMapper.getSpatial())
                .temporalDataLevel(dataMapper.getTemporal())
                .build();
    }
}
