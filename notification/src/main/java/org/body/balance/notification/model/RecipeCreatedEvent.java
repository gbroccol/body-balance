package org.body.balance.notification.model;

public record RecipeCreatedEvent(String generalId,
                                 String recipeId,
                                 String name,
                                 String ownerId) {
}
