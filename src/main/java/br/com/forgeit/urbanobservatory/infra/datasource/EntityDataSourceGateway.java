package br.com.forgeit.urbanobservatory.infra.datasource;

import br.com.forgeit.urbanobservatory.domain.model.Room;
import br.com.forgeit.urbanobservatory.infra.exception.EntityAlreadyExistsException;

public interface EntityDataSourceGateway {

    Room createRoom(Room newRoomRequest) throws EntityAlreadyExistsException;

}
