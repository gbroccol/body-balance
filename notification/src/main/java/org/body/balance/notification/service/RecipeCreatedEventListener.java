package org.body.balance.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.body.balance.notification.model.Notification;
import org.body.balance.notification.model.RecipeCreatedEvent;
import org.body.balance.notification.repository.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class RecipeCreatedEventListener {

    private final static String RECIPE_CREATED_TITLE = "Новый рецепт";
    private final static String RECIPE_CREATED_MESSAGE = "%s %s добавил(-а) новый рецепт \"%s\"";

    private final ObjectMapper objectMapper;
    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "recipe-created", groupId = "notification-group")
    public void handleNotificationCreating(String event) throws InterruptedException, JsonProcessingException {

        RecipeCreatedEvent recipeCreatedEvent = objectMapper.readValue(event, RecipeCreatedEvent.class);

        // todo если есть подписчики, получить массив пользователей, кому нужно отправить уведомление или return

        // todo инфу о пользователях (например, Иван Соколов, лить на БД сервиса не буду - буду обогащаться по апи и хранить в кеше в теч часа после последнего запроса)

        Notification notification = new Notification();
        notification.setUserId(UUID.randomUUID()); // todo передать подписчиков из БД
        notification.setTitle(RECIPE_CREATED_TITLE);
        notification.setMessage(String.format(RECIPE_CREATED_MESSAGE, "Иван", "Соколов", recipeCreatedEvent.name())); // todo убрать хардкод
        notification.setCreateDt(LocalDateTime.now());
        notification.setIsRead(false);

        notificationRepository.save(notification);
    }
}
