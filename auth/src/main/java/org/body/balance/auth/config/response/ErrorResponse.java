package org.body.balance.auth.config.response;

public record ErrorResponse(String error,
                            String message,
                            String details) {
}
