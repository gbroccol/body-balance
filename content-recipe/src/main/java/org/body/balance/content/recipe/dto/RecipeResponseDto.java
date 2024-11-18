package org.body.balance.content.recipe.dto;

import java.util.List;

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
