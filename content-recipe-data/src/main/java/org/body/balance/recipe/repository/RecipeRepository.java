package org.body.balance.recipe.repository;

import org.body.balance.recipe.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> { // todo crudRepository тоже можно ??? как тут лучше сделать
}
