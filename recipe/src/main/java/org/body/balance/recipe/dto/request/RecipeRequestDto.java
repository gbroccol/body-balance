package org.body.balance.recipe.dto.request;

import java.util.List;

public record RecipeRequestDto(String recipeId,
                               String name,
                               String description,
                               Integer cookingTimeMin,
                               Integer activeCookingTimeMin,
                               Integer portionQty,
                               Integer complexity,
                               Integer spiciness,
                               Long cuisineId,
                               List<StepRequestDto> steps,
                               List<Integer> tags,
                               List<IngredientRequestDto> ingredients) {
}
