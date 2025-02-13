package org.body.balance.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessages {

    USERNAME_NOT_FOUND("User with user_name = %s doesn't exist");
    private final String value;
}
