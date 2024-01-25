package com.sebin.microservices.core.user.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : PersistenceTests
 * @since : 1/19/24
 */

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PersistenceTests extends PostgreSqlTestBase {

  @Autowired
  private UserRepository userRepository;

  @BeforeEach
  public void setupDb() {
    userRepository.deleteAll();
  }

  @Test
  public void createUser() {

  }
}
