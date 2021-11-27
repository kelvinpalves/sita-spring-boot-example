package br.com.forgeit.urbanobservatory.infra.rest;

import br.com.forgeit.urbanobservatory.infra.dto.NewRoomRequest;
import br.com.forgeit.urbanobservatory.infra.exception.EntityAlreadyExistsException;
import br.com.forgeit.urbanobservatory.usecase.entity.create.CreateEntityInputBoundary;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/entity")
@RequiredArgsConstructor
public class EntityController {

    private final CreateEntityInputBoundary createService;

    @PostMapping
    public NewRoomRequest create(@RequestBody NewRoomRequest newRoomRequest) throws EntityAlreadyExistsException {
        return createService.createEntity(newRoomRequest);
    }


}
