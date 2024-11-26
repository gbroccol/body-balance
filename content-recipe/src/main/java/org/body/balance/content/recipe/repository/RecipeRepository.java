package org.body.balance.content.recipe.repository;

import org.body.balance.content.recipe.domain.food.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, String> {
}
