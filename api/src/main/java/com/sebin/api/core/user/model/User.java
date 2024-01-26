package com.sebin.api.core.user.model;

import lombok.Builder;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : User
 * @since : 1/18/24
 */
public class User {

  private final Long id;
  private final String email;
  private final String name;
  private final String password;


  @Builder
  public User(Long id, String email, String name, String password) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }
}
