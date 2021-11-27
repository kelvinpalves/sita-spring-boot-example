package br.com.forgeit.urbanobservatory.infra.repository.jpa;

import br.com.forgeit.urbanobservatory.infra.repository.model.RoomDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoomRepository extends JpaRepository<RoomDataMapper, String> {

}
