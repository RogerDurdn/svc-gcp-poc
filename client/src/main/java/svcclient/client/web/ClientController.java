package svcclient.client.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import svcclient.client.service.ClientService;

@RestController
@AllArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService service;

    @GetMapping("/load")
    public ResponseEntity<String> load(){
        log.info("loading all client--");
        return ResponseEntity.ok(service.load());
    }

}
