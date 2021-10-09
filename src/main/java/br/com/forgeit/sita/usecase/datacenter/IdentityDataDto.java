package br.com.forgeit.sita.usecase.datacenter;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Builder
@Data
@ToString
public class IdentityDataDto {
    private final String entityId;
    private final String name;
}
