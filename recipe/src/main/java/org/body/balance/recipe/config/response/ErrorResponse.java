package org.body.balance.recipe.config.response;

public record ErrorResponse(String error,
                            String message,
                            String details) {
}
