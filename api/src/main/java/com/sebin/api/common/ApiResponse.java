package com.sebin.api.common;

import java.time.ZonedDateTime;
import lombok.Builder;

/**
 * API 공통 응답 코드
 *
 * @author : sebin
 * @fileName : ApiResponse
 * @since : 1/26/24
 */
public class ApiResponse <T>{
  private boolean success;
  private String message;
  private T data;

  @Builder
  public ApiResponse(boolean success, String message, T data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  public static <T> ApiResponse<T> empty() {
    return success(null);
  }
  public static <T> ApiResponse<T> success(T data) {
    return ApiResponse.<T> builder()
        .message("SUCCESS!")
        .data(data)
        .success(true)
        .build();
  }

  public static <T> ApiResponse<T> error() {
    return ApiResponse.<T>builder()
        .message("ERROR!")
        .success(false)
        .build();
  }
}
