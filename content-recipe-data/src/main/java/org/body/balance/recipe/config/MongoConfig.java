package org.body.balance.recipe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// todo нужно ли создавать подпапки для разных БД?

@Configuration
@EnableMongoRepositories(basePackages = "org.body.balance.recipe.repository") // todo возможно лишнее - проверить
public class MongoConfig {
}
