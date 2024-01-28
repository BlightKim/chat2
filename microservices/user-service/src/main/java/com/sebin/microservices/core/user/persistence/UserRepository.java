package com.sebin.microservices.core.user.persistence;

import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Please explain the class!!
 *
 * @author : sebin
 * @fileName : UserRepository
 * @since : 1/19/24
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserEntity, Long> {


  @Transactional
  UserEntity save(@NotNull UserEntity userEntity);


  public Optional<UserEntity> findByEmail(String email);


}
