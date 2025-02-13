--liquibase formatted sql
--changeset gbroccol:2024-11-17--0006-fill-table-dictionary-cuisine

INSERT INTO dictionary.cuisine (cuisine_id, name)
VALUES (1, 'Русская'),
      (2, 'Итальянская'),
      (3, 'Украинская'),
      (4, 'Мексиканская'),
      (5, 'Французская'),
      (6, 'Вьетнамская');