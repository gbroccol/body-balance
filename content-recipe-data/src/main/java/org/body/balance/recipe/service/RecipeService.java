package org.body.balance.recipe.service;

import lombok.AllArgsConstructor;
import org.body.balance.recipe.domain.Recipe;
import org.body.balance.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;


    public void save() {

        Recipe recipe = new Recipe(null, "name", 45, 30, 4, 0); // todo fix
        Recipe recipe1 = recipeRepository.save(recipe);
        System.out.println(recipe1);

    }
}
