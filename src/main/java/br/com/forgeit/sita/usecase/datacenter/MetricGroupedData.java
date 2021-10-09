package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class MetricGroupedData {
    private TemporalDataDto temporalDataDto;
    private ActivityDataDto activityDataDto;
}
