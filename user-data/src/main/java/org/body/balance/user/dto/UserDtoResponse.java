package org.body.balance.user.dto;

import java.time.LocalDate;

public record UserDtoResponse(
        String username,
        String name,
        String surname,
        LocalDate birthDate) {
}
