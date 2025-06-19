package org.body.balance.recipe.dto.request;

public record RecipeStepRequestDto(String id,
                                   Integer number,
                                   String text,
                                   String image) {
}
