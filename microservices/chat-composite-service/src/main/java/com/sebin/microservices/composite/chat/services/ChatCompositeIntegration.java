package com.sebin.microservices.composite.chat.services;

import com.sebin.api.core.user.model.User;
import com.sebin.api.core.user.UserService;
import com.sebin.api.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/*

 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : ChatCompositeIntegration
 * @since : 1/18/24
*/
@Component
public class ChatCompositeIntegration implements UserService {

  private static final Logger log = LoggerFactory.getLogger(ChatCompositeIntegration.class);

  private final Scheduler publishEventScheduler;

  private final WebClient webClient;

  private final StreamBridge streamBridge;


  @Autowired
  public ChatCompositeIntegration(Scheduler publishEventScheduler, WebClient.Builder webClientBuilder,
      StreamBridge streamBridge) {
    this.publishEventScheduler = publishEventScheduler;
    this.webClient = webClientBuilder.build();
    this.streamBridge = streamBridge;
  }



  private void sendMessage(String bindingName, Event event) {
    log.debug("Sending a {} message to {}", event.getEventType(), bindingName);
    Message message = MessageBuilder.withPayload(event)
        .setHeader("partitionKey", event.getKey())
        .build();
    streamBridge.send(bindingName, message);
  }


  @Override
  public Mono<User> getUser(Long userId) {
    return null;
  }
}
