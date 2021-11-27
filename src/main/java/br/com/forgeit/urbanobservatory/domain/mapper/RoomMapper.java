package br.com.forgeit.urbanobservatory.domain.mapper;

import br.com.forgeit.urbanobservatory.domain.model.Room;
import br.com.forgeit.urbanobservatory.infra.dto.NewRoomRequest;
import br.com.forgeit.urbanobservatory.infra.repository.model.RoomDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface RoomMapper {

    @Mapping(source = "id", target = "entityId")
    @Mapping(source = "floor", target = "buildingFloor")
    Room newRoomRequestToRoom(NewRoomRequest newRoomRequest);

    @Mapping(target = "id", source = "entityId")
    @Mapping(target = "floor", source = "buildingFloor")
    NewRoomRequest roomToNewRoomRequest(Room room);

    @Mapping(source = "entityId", target = "id")
    RoomDataMapper roomToRoomDataMapper(Room room);

    @Mapping(target = "entityId", source = "id")
    Room roomDataMapperToRoom(RoomDataMapper roomDataMapper);

}
