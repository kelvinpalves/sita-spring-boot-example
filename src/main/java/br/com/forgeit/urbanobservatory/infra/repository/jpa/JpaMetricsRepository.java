package br.com.forgeit.urbanobservatory.infra.repository.jpa;

import br.com.forgeit.urbanobservatory.infra.repository.model.MetricDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMetricsRepository extends JpaRepository<MetricDataMapper, String> {

    @Query(
            value = "select * from " +
                    "(select * from metrics) as s1, " +
                    "(select unit, max(created_at) as created_at from metrics m2 where entity_id = ?1 group by unit) as s2 " +
                    "where s1.unit = s2.unit " +
                    "and s1.created_at = s2.created_at " +
                    "and s1.entity_id = ?1",
            nativeQuery = true
    )
    List<MetricDataMapper> findLatestByEntity(String entityId);

}
