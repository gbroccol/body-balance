package org.body.balance.recipe.dto.request;

import java.util.List;
import java.util.UUID;

public record RecipeRequestDto(UUID id,
                               String title,
                               String description,
                               Integer cookingTimeMin,
                               Integer activeCookingTimeMin,
                               Integer portionQty,
                               Integer complexity,
                               Integer spiciness,
                               Long cuisineId,
                               List<RecipeStepRequestDto> steps,
//  todo                             List<Integer> tags,
                               List<RecipeIngredientRequestDto> ingredients) {
}
