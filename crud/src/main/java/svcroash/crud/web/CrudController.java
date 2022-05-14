package svcroash.crud.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import svcroash.crud.model.DomainConfiguration;
import svcroash.crud.service.CrudService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CrudController {

    private CrudService crudService;

    @GetMapping("/all")
    public ResponseEntity<List<DomainConfiguration>> getAll(){
        return ResponseEntity.ok(crudService.getAllConfiguration());
    }

    @PostMapping("/")
    public ResponseEntity<DomainConfiguration> create(@RequestBody DomainConfiguration domain){
        DomainConfiguration configuration =crudService.createConfiguration(domain);
        String createdPath = String.format("/%v", configuration.getId());
        return ResponseEntity.created(URI.create(createdPath)).body(configuration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long id){
        crudService.deleteConfiguration(id);
        return ResponseEntity.accepted().build();
    }
}
