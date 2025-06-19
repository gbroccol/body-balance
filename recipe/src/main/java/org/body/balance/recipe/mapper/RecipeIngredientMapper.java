package org.body.balance.recipe.mapper;

import org.body.balance.recipe.domain.food.RecipeIngredient;
import org.body.balance.recipe.dto.response.RecipeIngredientResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeIngredientMapper {

    @Mapping(source = "product.id", target = "id")
    @Mapping(source = "product.name", target = "name")
    @Mapping(target = "quantity", expression = "java(mapQuantity(recipeIngredient))")
    RecipeIngredientResponseDto toResponseDto(RecipeIngredient recipeIngredient);

    default String mapQuantity(RecipeIngredient recipeIngredient) {
        if (recipeIngredient.getUnitOfMeasurement().getShortName() != null)
            return recipeIngredient.getQuantity() + " " + recipeIngredient.getUnitOfMeasurement().getShortName();
        return recipeIngredient.getQuantity() + " " + recipeIngredient.getUnitOfMeasurement().getName();
    }
}
