package br.com.forgeit.urbanobservatory.infra.repository;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table (name = "metrics")
@Data
@NoArgsConstructor
public class MetricDataMapper implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String unit;
    private String value;
    private LocalDateTime lastUpdate;
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    private RoomDataMapper entity;



}
