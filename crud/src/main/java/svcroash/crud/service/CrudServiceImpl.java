package svcroash.crud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import svcroash.crud.model.DomainConfiguration;
import svcroash.crud.repository.CrudConfigurationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CrudServiceImpl implements CrudService{

    private final CrudConfigurationRepository repository;

    @Override
    public DomainConfiguration createConfiguration(DomainConfiguration configuration) {
        return repository.save(configuration);
    }

    @Override
    public DomainConfiguration getConfigurationById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteConfiguration(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DomainConfiguration> getAllConfiguration() {
        return repository.findAll();
    }
}
