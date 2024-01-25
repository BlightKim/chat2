package com.sebin.microservices.core.user.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDateTime;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserEntity
 * @since : 1/18/24
 */
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue
  private Long id;

  @Version
  private int version;

  private String email;

  private String password;

  /**
   * 유저 상태(인증, 미인증, 정지, 탈퇴...)
   */
  @Enumerated(EnumType.STRING)
  private UserStatus userStatus;

  /**
   * 유저 권한
   */
  @Enumerated(EnumType.STRING)
  private UserRole userRole;

  /**
   * 유저 가입 날짜
   */
  private LocalDateTime createdAt;
  /**
   * 유저 인증 날짜
   */
  private LocalDateTime verifiedAt;

  /**
   * 유저 탈퇴 날짜
   */
  private LocalDateTime withdrawalAt;

  protected UserEntity() {

  }


  private UserEntity(Builder builder) {
    email = builder.email;
    password = builder.password;
    userStatus = builder.userStatus;
    userRole = builder.userRole;
    createdAt = builder.createdAt;
    verifiedAt = builder.verifiedAt;
    withdrawalAt = builder.withdrawalAt;
  }

  public static final class Builder {

    private String email;
    private String password;
    private UserStatus userStatus;
    private UserRole userRole;
    private LocalDateTime createdAt;
    private LocalDateTime verifiedAt;
    private LocalDateTime withdrawalAt;

    public Builder() {
    }

    public Builder email(String val) {
      email = val;
      return this;
    }

    public Builder password(String val) {
      password = val;
      return this;
    }

    public Builder userStatus(UserStatus val) {
      userStatus = val;
      return this;
    }

    public Builder userRole(UserRole val) {
      userRole = val;
      return this;
    }

    public Builder createdAt(LocalDateTime val) {
      createdAt = val;
      return this;
    }

    public Builder verifiedAt(LocalDateTime val) {
      verifiedAt = val;
      return this;
    }

    public Builder withdrawalAt(LocalDateTime val) {
      withdrawalAt = val;
      return this;
    }

    public UserEntity build() {
      return new UserEntity(this);
    }
  }
}
