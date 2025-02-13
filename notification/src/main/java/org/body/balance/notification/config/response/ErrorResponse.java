package org.body.balance.notification.config.response;

public record ErrorResponse(String error,
                            String message,
                            String details) {
}
