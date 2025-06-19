package org.body.balance.recipe.mapper;

import org.body.balance.recipe.domain.food.Recipe;
import org.body.balance.recipe.domain.food.RecipeIngredient;
import org.body.balance.recipe.domain.food.RecipeStep;
import org.body.balance.recipe.dto.request.RecipeIngredientRequestDto;
import org.body.balance.recipe.dto.request.RecipeRequestDto;
import org.body.balance.recipe.dto.request.RecipeStepRequestDto;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.dto.response.RecipeStepResponseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RecipeIngredientMapper.class})
public interface RecipeMapper {

    RecipeResponseDto toRecipeResponseDto(Recipe recipe);

    List<RecipeResponseDto> toRecipeResponseDto(List<Recipe> recipes);

    @Mapping(source = "photoUrl", target = "image")
    RecipeStepResponseDto toResponseDto(RecipeStep step);

    List<RecipeStepResponseDto> toResponseDto(List<RecipeStep> step);

    Recipe toEntity(RecipeRequestDto recipe);

    @Mapping(source = "id", target = "id.productId")
    @Mapping(source = "id", target = "product.id") // <== важно
    @Mapping(source = "unitId", target = "unitOfMeasurement.id")
    RecipeIngredient toEntity(RecipeIngredientRequestDto recipeIngredient); // todo вынести в др класс

    @Mapping(source = "image", target = "photoUrl")
    RecipeStep toEntity(RecipeStepRequestDto recipeStep); // todo вынести в др класс

    @AfterMapping
    default void after(@MappingTarget Recipe recipe) {

        for (RecipeStep recipeStep : recipe.getSteps()) {
            recipeStep.setRecipe(recipe);
        }

        for (RecipeIngredient ri : recipe.getIngredients()) {
            ri.getId().setRecipeId(recipe.getId());
            ri.setRecipe(recipe);
        }
    }
}

//    @AfterMapping
//    protected void afterToEntity(@MappingTarget Recipe recipe, RecipeRequestDto dto) {
//        if (dto.getIngredients() != null) {
//            List<RecipeIngredient> ingredients = toIngredientList(dto.getIngredients());
//
//            for (RecipeIngredient ingredient : ingredients) {
//                if (ingredient.getId() == null) {
//                    ingredient.setId(new RecipeIngredientId());
//                }
//                ingredient.getId().setRecipeId(dto.getId());
//            }
//
//            recipe.setIngredients(ingredients);
//        }
//    }

//    default Set<Tag> mapTagsToEntity(List<Integer> tags) {
//        Set<Tag> res = new HashSet<>();
//        for (Integer id : tags) {
//            res.add(new Tag(id, null, null));
//        }
//        return res;
//    }
