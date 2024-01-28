package com.sebin.api.core.user.signup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 회원가입을 위한 DTO 클래스 입니다.
 *
 * @author : sebin
 * @fileName : Signup
 * @since : 1/20/24
 */
public class Signup {

  @NotNull
  @NotBlank
  private final String name;
  @NotNull
  @NotBlank
  private final String email;
  @NotNull
  @NotBlank
  private final String password;
  @NotNull
  @NotBlank
  private final String confirmPassword;


  @JsonCreator
  public Signup(@JsonProperty("name") String name, @JsonProperty("email") String email,
      @JsonProperty("password") String password, @JsonProperty("confirmPassword") String confirmPassword) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  @AssertTrue(message = "패스워드가 일치하지 않습니다.")
  private boolean isPasswordMatching() {
    return this.password.equals(this.confirmPassword);
  }
  private Signup(Builder builder) {
    name = builder.name;
    email = builder.email;
    password = builder.password;
    confirmPassword = builder.confirmPassword;
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

  public static final class Builder {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public Builder() {
    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder email(String val) {
      email = val;
      return this;
    }

    public Builder password(String val) {
      password = val;
      return this;
    }

    public Builder confirmPassword(String val) {
      confirmPassword = val;
      return this;
    }

    public Signup build() {
      return new Signup(this);
    }
  }
}
