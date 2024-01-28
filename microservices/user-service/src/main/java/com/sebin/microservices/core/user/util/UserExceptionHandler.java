package com.sebin.microservices.core.user.util;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserExceptionHadnler
 * @since : 1/27/24
 */
@RestControllerAdvice
public class UserExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(UserExceptionHandler.class);

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public HttpErrorInfo handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {


    return new HttpErrorInfo(HttpStatus.BAD_REQUEST, request.getServletPath(), Objects.requireNonNull(
        ex.getFieldError()).getDefaultMessage());
  }
  private HttpErrorInfo createHttpErrorInfo(
      HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {

    final String path = request.getPath().pathWithinApplication().value();
    final String message = ex.getMessage();

    log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
    return new HttpErrorInfo(httpStatus, path, message);
  }
}
