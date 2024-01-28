package com.sebin.api.core.user.signup;

import lombok.Builder;
import lombok.Getter;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : SignupDto
 * @since : 1/26/24
 */
@Getter
public class SignupDto {
  private Integer id;


  @Builder
  public SignupDto(Integer id) {
    this.id = id;
  }
}
