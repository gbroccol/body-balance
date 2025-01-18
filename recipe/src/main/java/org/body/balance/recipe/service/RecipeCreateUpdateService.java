package org.body.balance.recipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.body.balance.recipe.config.logging.MonitoringConstants;
import org.body.balance.recipe.domain.food.Recipe;
import org.body.balance.recipe.domain.food.RecipeIngredient;
import org.body.balance.recipe.dto.RecipeCreatedEvent;
import org.body.balance.recipe.dto.request.RecipeRequestDto;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.mapper.RecipeMapper;
import org.body.balance.recipe.repository.IngredientRepository;
import org.body.balance.recipe.repository.RecipeRepository;
import org.body.balance.recipe.sender.DataSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Service
@RequiredArgsConstructor
public class RecipeCreateUpdateService {

    private final RecipeRepository repository;
    private final IngredientRepository ingredientRepository;
    private final RecipeMapper recipeMapper;
    private final DataSender dataSender;
    private final ObjectMapper om;

    public RecipeResponseDto handleRequest(RecipeRequestDto dto) throws JsonProcessingException {

        // todo выкидывать нормальные ошибки при попытке создать рецепт с несущ-м ингредиентом, тегом и тд
        // todo удалить проверку на БД - имя каждого рецепта должно быть уникально

        Recipe recipe = recipeMapper.toEntity(dto);
        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            recipeIngredient.setIngredient(ingredientRepository.getById(recipeIngredient.getId().getIngredientId())); // todo обработать, если не сущ-ет ингредиент
        }
        recipe = repository.save(recipe);

        dataSender.send(om.writeValueAsString(
                new RecipeCreatedEvent(getGeneralId(), recipe.getRecipeId(), recipe.getName(), recipe.getOwnerId().toString()))); // todo mapstruct

        return recipeMapper.toResponseDto(recipe);
    }

    private String getGeneralId() {
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder
                .currentRequestAttributes()
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        return (String) request.getAttribute(MonitoringConstants.HEADER_GENERAL_ID);
    }

}