package com.sebin.microservices.core.user.services;

import com.sebin.api.core.user.User;
import com.sebin.api.core.user.UserService;
import com.sebin.api.event.Event;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User-service의 메시지 처리 과정 설정 클래스 입니다.
 *
 * @author : sebin
 * @fileName : MessageProcessorConfig
 * @since : 1/20/24
 */
@Configuration
public class MessageProcessorConfig {
  private static final Logger log = LoggerFactory.getLogger(MessageProcessorConfig.class);

  private final UserService userService;

  @Autowired
  public MessageProcessorConfig(UserService userService) {
    this.userService = userService;
  }

  @Bean
  public Consumer<Event<Long, User>> messageProcessor() {
    return event -> {

      switch (event.getEventType()) {
        case CREATE -> {
          User data = event.getData();


        }
      }

    };
  }
}
