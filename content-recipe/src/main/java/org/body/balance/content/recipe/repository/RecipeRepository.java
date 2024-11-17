package org.body.balance.content.recipe.repository;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
