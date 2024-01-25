package com.sebin.microservices.composite.chat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : SchedulerConfig
 * @since : 1/18/24
 */
@Configuration
public class SchedulerConfig {
  private static final Logger log = LoggerFactory.getLogger(SchedulerConfig.class);

  @Bean
  public Scheduler publishEventScheduler(
      // 스케줄러의 쓰레드 풀 사이즈
      @Value("${app.thread-pool-size}") final Integer threadPoolSize,
      // 스케줄러의 taskQueue 사이즈
      @Value("${app.task-queue-size}") final Integer taskQueueSize
  ) {
    log.info("스케줄러 생성, 커넥션 풀 크기: {}", threadPoolSize);

    return Schedulers.newBoundedElastic(threadPoolSize, taskQueueSize, "publish-pool");
  }
}
