package com.sebin.api.core.user;

/**
 * 회원가입을 위한 DTO 클래스 입니다.
 *
 * @author : sebin
 * @fileName : Signup
 * @since : 1/20/24
 */
public class Signup {
  private final String email;
  private final String name;
  private final String password;
  private final String confirmPassword;

  public Signup(String email, String name, String password, String confirmPassword) {
    this.email = email;
    this.name = name;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  private Signup(Builder builder) {
    email = builder.email;
    name = builder.name;
    password = builder.password;
    confirmPassword = builder.confirmPassword;
  }


  public static final class Builder {

    private final String email;
    private final String name;
    private final String password;
    private final String confirmPassword;

    public Builder(String email, String name, String password, String confirmPassword) {
      this.email = email;
      this.name = name;
      this.password = password;
      this.confirmPassword = confirmPassword;
    }

    public Signup build() {
      return new Signup(this);
    }
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

  public String getConfirmPassword() {
    return confirmPassword;
  }
}
