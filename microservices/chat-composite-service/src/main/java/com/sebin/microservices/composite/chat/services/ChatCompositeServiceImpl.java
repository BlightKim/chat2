package com.sebin.microservices.composite.chat.services;

import com.sebin.api.composite.chat.ChatCompositeService;
import com.sebin.api.core.user.Signup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : ChatCompositeServiceImpl
 * @since : 1/22/24
 */

@RestController
public class ChatCompositeServiceImpl implements ChatCompositeService {
  private static final Logger log = LoggerFactory.getLogger(ChatCompositeService.class);

  private final ChatCompositeIntegration integration;

  @Autowired
  public ChatCompositeServiceImpl(ChatCompositeIntegration integration) {
    this.integration = integration;
  }
}
