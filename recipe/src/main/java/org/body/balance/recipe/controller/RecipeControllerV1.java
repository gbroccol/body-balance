package org.body.balance.recipe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.body.balance.recipe.dto.request.RecipeRequestDto;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.exception.SendDataToKafkaException;
import org.body.balance.recipe.service.RecipeCreateUpdateService;
import org.body.balance.recipe.service.RecipeDeleteService;
import org.body.balance.recipe.service.RecipeGetAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeControllerV1 {

    private final static String PAGE_SIZE_DEFAULT = "10";

    private final RecipeGetAllService recipeGetAllService;
    private final RecipeCreateUpdateService recipeCreateUpdateService;
    private final RecipeDeleteService recipeDeleteService;

    @GetMapping
    public ResponseEntity<List<RecipeResponseDto>> get(@NotNull @RequestParam Integer page,
                                                       @RequestParam(defaultValue = PAGE_SIZE_DEFAULT) Integer size) {
        return new ResponseEntity<>(recipeGetAllService.handleRequest(page, size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeResponseDto> createUpdate(@RequestBody RecipeRequestDto dto) {
        try {
            return new ResponseEntity<>(recipeCreateUpdateService.handleRequest(dto), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(@NotNull @RequestParam String recipeId) {
        return new ResponseEntity<>(recipeDeleteService.handleRequest(recipeId), HttpStatus.OK);
    }

}
