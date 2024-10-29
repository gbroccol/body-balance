package org.body.balance.auth.repository;

import org.body.balance.auth.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    AuthUser findByUsername(String username);
}
