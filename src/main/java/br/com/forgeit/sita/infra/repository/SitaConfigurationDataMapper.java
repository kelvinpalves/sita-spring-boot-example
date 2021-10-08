package br.com.forgeit.sita.infra.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "sita_config")
@Data
@NoArgsConstructor
public class SitaConfigurationDataMapper implements Serializable {
    @Id
    private Integer id;
    private Integer spatial;
    private Integer identity;
    private Integer temporal;
    private Integer activity;
}
