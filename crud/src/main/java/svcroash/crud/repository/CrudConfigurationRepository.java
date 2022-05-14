package svcroash.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import svcroash.crud.model.DomainConfiguration;

import java.util.List;

@Repository
public interface CrudConfigurationRepository extends CrudRepository<DomainConfiguration, Long> {

    @Override
    List<DomainConfiguration> findAll();
}
