package svcroash.crud.util;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import svcroash.crud.model.DomainConfiguration;
import svcroash.crud.model.Feature;
import svcroash.crud.repository.CrudConfigurationRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Profile("test")
@ConfigurationProperties(prefix = "loader")
@Setter
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {

  private final CrudConfigurationRepository repository;
  private  Integer configs;
  private  Integer features;

  public DataLoader(
      CrudConfigurationRepository repository) {
    this.repository = repository;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
      if(repository.count()< 10){
        repository.saveAll(buildConfigurations());
      }
  }

  private List<DomainConfiguration> buildConfigurations() {
    return IntStream.range(0, configs)
        .mapToObj(i -> new DomainConfiguration(buildFeature()))
        .collect(Collectors.toList());
  }

  private List<Feature> buildFeature() {
    return IntStream.range(0, features)
        .mapToObj(i -> new Feature("value" + i))
        .collect(Collectors.toList());
  }
}
