package br.com.forgeit.urbanobservatory.infra.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewRoomRequest {

    String id;
    String building;
    Integer floor;
    String name;
    String roomNumber;
    LocalDateTime createdAt;

}
