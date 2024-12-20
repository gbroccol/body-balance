package org.body.balance.recipe.service;

import org.body.balance.recipe.domain.food.Recipe;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.mapper.RecipeMapper;
import org.body.balance.recipe.repository.RecipeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RecipeGetAllService(RecipeRepository repository,
                                  RecipeMapper recipeMapper) {

    public List<RecipeResponseDto> handleRequest(int page, int size) {
        Page<Recipe> res = repository.findByDeleteDtIsNull(PageRequest.of(page, size));
        return recipeMapper.toResponseDto(res.getContent());
    }
}
