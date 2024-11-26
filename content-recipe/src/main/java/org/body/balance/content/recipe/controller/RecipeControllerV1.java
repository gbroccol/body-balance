package org.body.balance.content.recipe.controller;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.body.balance.content.recipe.dto.request.RecipeRequestDto;
import org.body.balance.content.recipe.dto.response.RecipeResponseDto;
import org.body.balance.content.recipe.service.RecipeCreateUpdateService;
import org.body.balance.content.recipe.service.RecipeGetAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeControllerV1 {

    private final RecipeGetAllService recipeGetAllService;
    private final RecipeCreateUpdateService recipeCreateUpdateService;

    @GetMapping
    public ResponseEntity<List<RecipeResponseDto>> get(@NotNull @RequestParam Integer page,
                                                       @RequestParam(defaultValue = "10") Integer size) { // todo переменная
        return new ResponseEntity<>(recipeGetAllService.handleRequest(page, size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeResponseDto> createUpdate(@RequestBody RecipeRequestDto dto) {
        return new ResponseEntity<>(recipeCreateUpdateService.handleRequest(dto), HttpStatus.OK);
    }

}