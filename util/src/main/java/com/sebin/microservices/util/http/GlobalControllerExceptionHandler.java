package com.sebin.microservices.util.http;

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
 * Exception을 처리하는 클래스
 *
 * @author : sebin
 * @fileName : Gl
 * @since : 1/27/24
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public HttpErrorInfo handleMethodArgumentNotValidException(ServerHttpRequest serverHttpRequest, MethodArgumentNotValidException ex) {
    return createHttpErrorInfo(HttpStatus.BAD_REQUEST, serverHttpRequest, ex);
  }

  private HttpErrorInfo createHttpErrorInfo(
      HttpStatus httpStatus, ServerHttpRequest serverHttpRequest, Exception ex) {

    final String path = serverHttpRequest.getPath().pathWithinApplication().value();
    final String message = ex.getMessage();

    log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
    return new HttpErrorInfo(httpStatus, path, message);
  }
}
