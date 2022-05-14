package svcclient.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import svcclient.client.client.ClientConsumer;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientConsumer consumer;
  private final String urlToConsume;

  public ClientServiceImpl(ClientConsumer consumer, @Value("${consumer.url}") String urlToConsume) {

    this.consumer = consumer;
    this.urlToConsume = urlToConsume;
  }

  @Override
  public String load() {
    return consumer.consume(urlToConsume);
  }
}
