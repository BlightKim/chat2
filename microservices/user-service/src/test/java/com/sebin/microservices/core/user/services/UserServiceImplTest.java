package com.sebin.microservices.core.user.services;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.sebin.api.core.user.signup.Signup;
import com.sebin.api.core.user.model.User;
import com.sebin.api.event.Event;
import com.sebin.microservices.core.user.persistence.PostgreSqlTestBase;
import com.sebin.microservices.core.user.persistence.UserRepository;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserServiceImplTest
 * @since : 1/24/24
 */
@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {
    "spring.cloud.stream.defaultBinder=rabbit",
    "logging.level.com.sebin=DEBUG",
    "eureka.client.enabled=false"})
class UserServiceImplTest extends PostgreSqlTestBase {

  @Autowired
  private WebTestClient webTestClient;

  @Autowired
  private UserRepository userRepository;


  @Autowired
  @Qualifier("messageProcessor")
  private Consumer<Event<Long, User>> messageProcessor;


  @BeforeEach
  void setup() {
    userRepository.deleteAll();
  }

  @Test
  public void 컨트롤러_테스트() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("")
        .email("ksebin96@gmail.com")
        .password("1234")
        .confirmPassword("1234")
        .build();

    webTestClient.post()
        .uri("/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isOk();
  }
}