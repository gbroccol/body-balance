package org.body.balance.user.config.response;

public record ErrorResponse(String error,
                            String message,
                            String details) {
}
