package svcroash.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feature", schema = "crud")
@NoArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "configuration_id", nullable = false)
    @JsonBackReference
    private DomainConfiguration configuration;
    private String value;
    public Feature(String value){
        this.value = value;
    }
}
