package br.com.forgeit.urbanobservatory.usecase.entity.create;

import br.com.forgeit.urbanobservatory.infra.dto.NewRoomRequest;
import br.com.forgeit.urbanobservatory.infra.exception.EntityAlreadyExistsException;

public interface CreateEntityInputBoundary {

    NewRoomRequest createEntity(NewRoomRequest request) throws EntityAlreadyExistsException;

}
