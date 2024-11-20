package org.body.balance.auth.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(schema = "auth", name = "users")
public class AuthUser {

    @Id
    private String uuid;

    private String username;

    private String email;

    private String password;
}