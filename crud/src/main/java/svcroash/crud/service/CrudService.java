package svcroash.crud.service;

import svcroash.crud.model.DomainConfiguration;

import java.util.List;

public interface CrudService {
    DomainConfiguration createConfiguration(DomainConfiguration configuration);
    DomainConfiguration getConfigurationById(Long id);
    void deleteConfiguration(Long id);
    List<DomainConfiguration> getAllConfiguration();
}
