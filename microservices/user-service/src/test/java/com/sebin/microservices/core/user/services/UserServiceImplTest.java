package com.sebin.microservices.core.user.services;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.sebin.api.core.user.signup.Signup;
import com.sebin.api.core.user.model.User;
import com.sebin.api.event.Event;
import com.sebin.microservices.core.user.persistence.PostgreSqlTestBase;
import com.sebin.microservices.core.user.persistence.UserEntity;
import com.sebin.microservices.core.user.persistence.UserRepository;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.ExchangeResult;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

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
  private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


  @Autowired
  private WebTestClient webTestClient;

  @MockBean
  private UserRepository userRepository;


  @Autowired
  @Qualifier("messageProcessor")
  private Consumer<Event<Long, User>> messageProcessor;


  @BeforeEach
  void setup() {
    userRepository.deleteAll();
  }

  @Test
  public void 이름은_공백일_수_없다() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("")
        .email("ksebin96@gmail.com")
        .password("1234")
        .confirmPassword("1234")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isBadRequest().returnResult(Void.class);

    log.info("result={}", result);

 }


  @Test
  public void 비밀번호는_공백일_수_없다() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("김세빈")
        .email("ksebin96@gmail.com")
        .password("")
        .confirmPassword("1234")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isBadRequest().returnResult(Void.class);

    log.info("result={}", result);

  }

  @Test
  public void 이메일은_공백일_수_없다() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("김세빈")
        .email("")
        .password("1234")
        .confirmPassword("1234")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isBadRequest().returnResult(Void.class);

    log.info("result={}", result);

  }

  @Test
  public void 비밀번호와_확인_비밀번호가_같지_않으면_400() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("김세빈")
        .email("ksebin96@gmail.com")
        .password("123")
        .confirmPassword("1234")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isBadRequest().returnResult(Void.class);

    log.info("result={}", result);

  }




  @Test
  public void 확인_비밀번호는_공백일_수_없다() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("김세빈")
        .email("ksebin96@gmail.com")
        .password("1234")
        .confirmPassword("")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isBadRequest().returnResult(Void.class);

    log.info("result={}", result);
  }

  @Test
  public void 모든_입력_정보의_유효성이_통과될경우_200status() throws Exception {
    Signup body = new Signup
        .Builder()
        .name("김세빈")
        .email("ksebin96@gmail.com")
        .password("1234")
        .confirmPassword("1234")
        .build();

    UserEntity userEntity = UserEntity.from(body);

    Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

    ExchangeResult result = webTestClient.post()
        .uri("/api/v1/user")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .exchange()
        .expectStatus().isOk().returnResult(Void.class);

    log.info("result={}", result);
  }

}