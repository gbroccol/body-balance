package org.body.balance.recipe.service;

import org.body.balance.recipe.domain.food.Recipe;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.mapper.RecipeMapper;
import org.body.balance.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public record RecipeGetByIdService(RecipeRepository repository,
                                   RecipeMapper recipeMapper) {

    public RecipeResponseDto handleRequest(String id) {
        Optional<Recipe> res = repository.findById(UUID.fromString(id)); // todo bad request
        return recipeMapper.toRecipeResponseDto(res.orElseGet(null)); // todo
    }
}
