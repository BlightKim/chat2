package com.sebin.microservices.core.user;

import com.sebin.api.core.user.User;
import com.sebin.api.event.Event;
import com.sebin.microservices.core.user.persistence.PostgreSqlTestBase;
import com.sebin.microservices.core.user.persistence.UserRepository;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServiceApplicationTests extends PostgreSqlTestBase {

  @Autowired
  private UserRepository userrepository;
  @Autowired
  private WebTestClient webTestClient;

  @Autowired
  @Qualifier("messageProcessor")
  private Consumer<Event<Long, User>> messageProcessor;
  @Test
  void contextLoads() {
  }

}
