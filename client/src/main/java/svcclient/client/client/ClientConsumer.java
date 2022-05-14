package svcclient.client.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientConsumer {

    private final WebClient webClient;

  public ClientConsumer() {
    this.webClient =
        WebClient.builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
            .build();
  }

    public String consume(String url){
        try {
            return webClient.get().uri(url).retrieve().toEntity(String.class).block().getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("some wrong just happened");
        }
    }

}
