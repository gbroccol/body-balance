package org.body.balance.recipe.dto;

public record RecipeCreatedEvent(String generalId,
                                 String recipeId,
                                 String name,
                                 String ownerId) {
}
