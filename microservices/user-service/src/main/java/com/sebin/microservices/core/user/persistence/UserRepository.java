package com.sebin.microservices.core.user.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserRepository
 * @since : 1/19/24
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {


  @Transactional
  public UserEntity save(UserEntity userEntity);

}
