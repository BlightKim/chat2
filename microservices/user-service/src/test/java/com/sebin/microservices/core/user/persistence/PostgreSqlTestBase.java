package com.sebin.microservices.core.user.persistence;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : PostgreSqlTestBase
 * @since : 1/19/24
 */

public abstract class PostgreSqlTestBase {
  private static JdbcDatabaseContainer<?> databaseContainer = new PostgreSQLContainer<>("postgres:16.0").withStartupTimeoutSeconds(300);

  static {
    databaseContainer.start();
  }

  @DynamicPropertySource
  static void databaseProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", databaseContainer::getJdbcUrl);
    registry.add("spring.datasource.username", databaseContainer::getUsername);
    registry.add("spring.datasource.password", databaseContainer::getPassword);
  }
}
