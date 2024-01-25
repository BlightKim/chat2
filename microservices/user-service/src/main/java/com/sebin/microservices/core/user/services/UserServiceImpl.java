package com.sebin.microservices.core.user.services;

import com.sebin.api.core.user.Signup;
import com.sebin.api.core.user.User;
import com.sebin.api.core.user.UserService;
import com.sebin.microservices.core.user.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserServiceImpl
 * @since : 1/18/24
 */
@RestController
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
  public Mono<User> createUser(Signup body) {
    return null;
  }


  @Override
  public Mono<User> getUser(Long userId) {
   return null;
  }
}
