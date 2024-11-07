package org.body.balance.recipe.config.mongock.changelog; // todo ВОПРОС по какому пути лучше хранить ChangeSet?

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.body.balance.recipe.domain.Recipe;
import org.body.balance.recipe.repository.RecipeRepository;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "gbroccol", runAlways = true) // todo удалить после тестов
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertRecipes", author = "gbroccol")
    public void insertPushkin(RecipeRepository repository) {
        repository.save(new Recipe(null, "Кабачковые драники", 20, 20, 4, 0));
        repository.save(new Recipe(null, "Сырники", 20, 20, 4, 0));
        repository.save(new Recipe(null, "Хачапури по-мегрельски", 20, 20, 4, 0));
        repository.save(new Recipe(null, "Шакшука", 40, 30, 4, 0));
    }
}