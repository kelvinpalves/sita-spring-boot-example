package br.com.forgeit.urbanobservatory.usecase.entity.create;

import br.com.forgeit.urbanobservatory.domain.mapper.RoomMapper;
import br.com.forgeit.urbanobservatory.domain.model.Room;
import br.com.forgeit.urbanobservatory.infra.datasource.EntityDataSourceGateway;
import br.com.forgeit.urbanobservatory.infra.dto.NewRoomRequest;
import br.com.forgeit.urbanobservatory.infra.exception.EntityAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateEntityInteractor implements CreateEntityInputBoundary {

    private final EntityDataSourceGateway dataSourceGateway;
    private final RoomMapper roomMapper;

    @Override
    public NewRoomRequest createEntity(NewRoomRequest request) throws EntityAlreadyExistsException {
        log.info("NewRoomRequest={}", request);
        Room room = roomMapper.newRoomRequestToRoom(request);
        room = dataSourceGateway.createRoom(room);
        return roomMapper.roomToNewRoomRequest(room);
    }
}
