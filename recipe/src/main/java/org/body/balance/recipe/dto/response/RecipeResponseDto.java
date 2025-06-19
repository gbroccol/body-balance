package org.body.balance.recipe.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RecipeResponseDto(String id,
                                String title,
                                String description,
                                Integer cookingTimeMin,
                                Integer activeCookingTimeMin,
                                Integer portionQty,
                                Integer complexity,
                                Integer spiciness,
// todo                               CuisineResponseDto cuisine,
                                List<RecipeStepResponseDto> steps,
//   todo                             List<TagResponseDto> tags
                                List<RecipeIngredientResponseDto> ingredients
) {
}
