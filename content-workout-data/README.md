# Content Article Data

## Описание
Модуль для управления контентом (тренировки). Поддерживает процесс модерации перед публикацией.

## Основные возможности
- CRUD операции для контента.
- Модерация контента перед публикацией.

## API
- POST `/content/workout` - Добавление нового контента.
- GET `/content/workout/{id}` - Получение контента.
- PUT `/content/workout/{id}` - Обновление контента.
- DELETE `/content/workout/{id}` - Удаление контента.

## Технологии
- Spring Boot
- Spring Data JPA