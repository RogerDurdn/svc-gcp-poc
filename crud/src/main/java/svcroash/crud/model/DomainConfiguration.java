package svcroash.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "configuration",schema = "crud")
@NoArgsConstructor
public class DomainConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "configuration", cascade = CascadeType.ALL)
    private List<Feature> features;

    public DomainConfiguration(List<Feature> features){
        features.forEach(f-> f.setConfiguration(this));
        this.features = features;
    }
}
