package org.body.balance.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(schema = "userinfo", name = "users")
public class User {

    @Id
    private String uuid;

    private String username;

    private String name;

    private String surname;

    private LocalDate birthDate;
}
