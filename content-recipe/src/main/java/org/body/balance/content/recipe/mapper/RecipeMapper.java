package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.body.balance.content.recipe.domain.food.RecipeIngredient;
import org.body.balance.content.recipe.dto.IngredientResponseDto;
import org.body.balance.content.recipe.dto.RecipeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(source = "ingredient.ingredientId", target = "ingredientId")
    @Mapping(source = "ingredient.name", target = "ingredientName")
    @Mapping(source = "unit.unitId", target = "unitId")
    @Mapping(source = "unit.name", target = "unitName")
    @Mapping(source = "unit.shortName", target = "unitShortName")
    IngredientResponseDto toResponseDto(RecipeIngredient recipeIngredient);

    RecipeResponseDto toResponseDto(Recipe recipe);

}