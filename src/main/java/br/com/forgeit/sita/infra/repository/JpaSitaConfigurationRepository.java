package br.com.forgeit.sita.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSitaConfigurationRepository extends JpaRepository<SitaConfigurationDataMapper, Integer> {
}
