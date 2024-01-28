package com.sebin.api.core.user;

import com.sebin.api.common.ApiResponse;
import com.sebin.api.core.user.model.User;
import com.sebin.api.core.user.signup.Signup;
import com.sebin.api.core.user.signup.SignupDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserService
 * @since : 1/18/24
 */
@RequestMapping("/api/v1")
public interface UserService {
  @GetMapping(
      value = "/user/{userId}",
      produces = "application/json"
  )
  public Mono<User> getUser(@PathVariable Long userId);

  /**
   * User를 생성하고 생성한 User를 반환한다.
   * @param body
   * @return
   */

@PostMapping(
    value = "/user",
    produces = "application/json"
)
  public  Mono<ResponseEntity<ApiResponse<SignupDto>>> createUser(@RequestBody @Valid Signup body);
}