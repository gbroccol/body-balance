--liquibase formatted sql
--changeset gbroccol:2024-11-17--0005-fill-table-dictionary-unit

INSERT INTO dictionary.unit(unit_id, name, short_name)
VALUES (1, 'стакан', null),
        (2, 'столовая ложка', 'ст.л.'),
        (3, 'чайная ложка', 'ч.л'),
        (4, 'штука', 'шт.'),
        (5, 'зубчик', null),
        (6, 'лист', null),
        (7, 'грамм', 'г.'),
        (8, 'килограмм', 'кг.'),
        (9, 'миллилитр', 'мл.'),
        (10, 'литр', 'л.'),
        (11, 'по вкусу', null);
