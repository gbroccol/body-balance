package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.body.balance.content.recipe.dto.RecipeResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    RecipeResponseDto toResponseDto(Recipe recipe);

}