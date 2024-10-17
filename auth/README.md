# Auth Service

## Описание
Модуль аутентификации и авторизации. 
Предоставляет функционал для регистрации и входа пользователей, а также управления ролями и правами доступа.

## Основные возможности
- Регистрация обычных пользователей и компаний.
- Генерация и валидация JWT-токенов.
- Управление ролями и правами доступа для сотрудников компаний.
- Защита API через Spring Security.

## API
- POST `v1/auth/register` - Регистрация пользователя или компании.
- POST `v1/auth/login` - Вход пользователя.
- GET  `v1/auth/info` - Получение информации о текущем пользователе.

## Технологии
- Spring Boot
- Spring Security
- JWT