package org.body.balance.recipe.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RecipeResponseDto(String recipeId,
                                String name,
                                String description,
                                Integer cookingTimeMin,
                                Integer activeCookingTimeMin,
                                Integer portionQty,
                                Integer complexity,
                                Integer spiciness,
                                CuisineResponseDto cuisine,
                                List<StepResponseDto> steps,
                                List<TagResponseDto> tags,
                                List<IngredientResponseDto> ingredients) {
}
