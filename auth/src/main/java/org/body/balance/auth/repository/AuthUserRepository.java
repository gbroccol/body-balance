package org.body.balance.auth.repository;

import org.body.balance.auth.domain.AuthUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUser, String> {
    Optional<AuthUser> findByUsername(String username);
}
