package org.body.balance.content.recipe.mapper;

import org.body.balance.content.recipe.domain.dictionary.Tag;
import org.body.balance.content.recipe.domain.dictionary.Unit;
import org.body.balance.content.recipe.domain.food.*;
import org.body.balance.content.recipe.dto.request.IngredientRequestDto;
import org.body.balance.content.recipe.dto.response.IngredientResponseDto;
import org.body.balance.content.recipe.dto.request.RecipeRequestDto;
import org.body.balance.content.recipe.dto.response.RecipeResponseDto;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(source = "ingredient.ingredientId", target = "ingredientId")
    @Mapping(source = "ingredient.name", target = "ingredientName")
    @Mapping(source = "unit.unitId", target = "unitId")
    @Mapping(source = "unit.name", target = "unitName")
    @Mapping(source = "unit.shortName", target = "unitShortName")
    IngredientResponseDto toResponseDto(RecipeIngredient recipeIngredient);

    List<RecipeResponseDto> toResponseDto(List<Recipe> recipes);

    RecipeResponseDto toResponseDto(Recipe recipe);

    @Mapping(target = "cuisine.cuisineId", source = "cuisineId")
    Recipe toEntity(RecipeRequestDto recipe);

    default Set<Tag> mapTagsToEntity(List<Integer> tags) {
        Set<Tag> res = new HashSet<>();
        for (Integer id : tags) {
            res.add(new Tag(id, null, null));
        }
        return res;
    }

    default List<RecipeIngredient> mapIngredientsToEntity(List<IngredientRequestDto> ingredients) {
        List<RecipeIngredient> res = new ArrayList<>();

        for (IngredientRequestDto dto : ingredients) {
            Ingredient ingredient = new Ingredient(dto.ingredientId(), null, null);
            Unit unit = new Unit(dto.unitId(), null, null, null);
            RecipeIngredientId recipeIngredientId = new RecipeIngredientId(null, dto.ingredientId());
            RecipeIngredient recipeIngredient = new RecipeIngredient(recipeIngredientId, null, ingredient, unit, dto.amount());
            res.add(recipeIngredient);
        }

        return res;
    }

    @AfterMapping
    default void after(@MappingTarget Recipe recipe) {

        for (Step step : recipe.getSteps()) {
            step.setRecipe(recipe);
        }

        for (RecipeIngredient ri : recipe.getIngredients()) {
            ri.getId().setRecipeId(recipe.getRecipeId());
            ri.setRecipe(recipe);
        }
    }
}