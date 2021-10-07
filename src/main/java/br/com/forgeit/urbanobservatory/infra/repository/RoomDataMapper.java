package br.com.forgeit.urbanobservatory.infra.repository;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table (name = "entity")
@Data
@NoArgsConstructor
public class RoomDataMapper implements Serializable  {

    @Id
    private String id;
    private String name;
    private String building;
    private Integer buildingFloor;
    private String roomNumber;
    private LocalDateTime createdAt;

}
