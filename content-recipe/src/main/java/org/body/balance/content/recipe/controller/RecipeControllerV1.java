package org.body.balance.content.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.body.balance.content.recipe.dto.RecipeResponseDto;
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

    @GetMapping
    public ResponseEntity<List<RecipeResponseDto>> getAll() {
        return new ResponseEntity<>(recipeGetAllService.handleRequest(), HttpStatus.OK);
    }

}
