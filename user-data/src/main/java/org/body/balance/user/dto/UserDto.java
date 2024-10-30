package org.body.balance.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.body.balance.user.domain.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {

    private String username;

    private String name;

    private String surname;

    private LocalDate birthDate;

    public static UserDto toDto(User user) {
        return new UserDto(user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getBirthDate());
    }
}
