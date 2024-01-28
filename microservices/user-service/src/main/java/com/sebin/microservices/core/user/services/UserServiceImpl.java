package com.sebin.microservices.core.user.services;

import com.sebin.api.common.ApiResponse;
import com.sebin.api.core.user.UserService;
import com.sebin.api.core.user.model.User;
import com.sebin.api.core.user.signup.Signup;
import com.sebin.api.core.user.signup.SignupDto;
import com.sebin.microservices.core.user.persistence.UserEntity;
import com.sebin.microservices.core.user.persistence.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * UserService를 구현
 *
 * @author : sebin
 * @fileName : UserServiceImpl
 * @since : 1/18/24
 */
@RestController
@Validated
public class UserServiceImpl implements UserService {
  private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  private final UserRepository userRepository;
  private final Scheduler jdbcScheduler;


  @Autowired
  public UserServiceImpl(UserRepository userRepository, @Qualifier("jdbcScheduler") Scheduler jdbcScheduler) {
    this.userRepository = userRepository;
    this.jdbcScheduler = jdbcScheduler;
  }

  @Override
  public Mono<ResponseEntity<ApiResponse<SignupDto>>> createUser(@RequestBody @Valid Signup body) {
    log.info("회원가입 시작: {}", body);

    userRepository.findByEmail(body.getEmail());
    UserEntity userEntity = UserEntity.from(body);
    UserEntity save = userRepository.save(userEntity);
    return Mono.just(ResponseEntity.ok(ApiResponse.success(SignupDto.builder().id(1).build())));
  }


  @Override
  public Mono<User> getUser(Long userId) {
   return null;
  }
}
