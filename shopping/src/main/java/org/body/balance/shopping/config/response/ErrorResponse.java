package org.body.balance.shopping.config.response;

public record ErrorResponse(String error,
                            String message,
                            String details) {
}
