----liquibase formatted sql
--
----changeset gbroccol:2024-10-30--0003-insert-into-userinfo-users
INSERT INTO userinfo.users (user_id, username, name, surname, birth_date, change_dt)
VALUES ('6081d313-372e-46e4-b3c5-5ca1756b0665', 'user', 'Вася', 'Пупкин', '1990-01-01', now()),
       ('fdd3c0c5-01ee-4cc6-8d86-ce47c7a4b57a', 'admin', 'Света', 'Соколова', '2005-08-07', now());