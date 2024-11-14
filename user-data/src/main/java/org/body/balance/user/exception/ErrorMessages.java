package org.body.balance.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessages {
    NOT_FOUND("User with username = %s doesn't exist");
    private final String value;
}
