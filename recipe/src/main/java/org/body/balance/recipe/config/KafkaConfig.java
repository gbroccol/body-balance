package org.body.balance.recipe.config;

import org.body.balance.recipe.sender.DataSender;
import org.body.balance.recipe.sender.DataSenderKafka;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@PropertySource("classpath:application.yml")
public class KafkaConfig {

    private final String topicRecipeCreated;

    public KafkaConfig(@Value("${application.kafka.topic.recipe-created:recipe-created}") String topicRecipeCreated) {
        this.topicRecipeCreated = topicRecipeCreated;
    }

    @Bean
    public DataSender purchaseCreated(KafkaTemplate<String, String> kafkaTemplate) {
        return new DataSenderKafka(topicRecipeCreated, kafkaTemplate);
    }

}
