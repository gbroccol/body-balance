package org.body.balance.content.recipe.service;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.body.balance.content.recipe.dto.RecipeResponseDto;
import org.body.balance.content.recipe.mapper.RecipeMapper;
import org.body.balance.content.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public record RecipeGetAllService(RecipeRepository repository,
                                  RecipeMapper recipeMapper) {

    public List<RecipeResponseDto> handleRequest() {
        Iterable<Recipe> recipes = repository.findAll();
        return StreamSupport.stream(recipes.spliterator(), false)
                .map(recipeMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
