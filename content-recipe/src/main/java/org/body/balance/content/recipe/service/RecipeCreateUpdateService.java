package org.body.balance.content.recipe.service;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.body.balance.content.recipe.dto.request.RecipeRequestDto;
import org.body.balance.content.recipe.dto.response.RecipeResponseDto;
import org.body.balance.content.recipe.mapper.RecipeMapper;
import org.body.balance.content.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public record RecipeCreateUpdateService(RecipeRepository repository,
                                        RecipeMapper recipeMapper) {

    public RecipeResponseDto handleRequest(RecipeRequestDto dto) {
        Recipe recipe = repository.save(recipeMapper.toEntity(dto));
        return recipeMapper.toResponseDto(recipe);
    }

}