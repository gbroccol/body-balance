--liquibase formatted sql

--changeset gbroccol:2024-11-05--0002-create-tables-for-tags
CREATE TABLE IF NOT EXISTS dictionary.Tag
(
    tag_id       BIGINT      NOT NULL,
    tag_name     VARCHAR(50) NOT NULL,
    CONSTRAINT PK_Tag PRIMARY KEY (tag_id),
    CONSTRAINT UQ_Tag_name UNIQUE (tag_name)
);

-- один тег может принадлежать нескольким группам
-- нужны для фильтров (поиск по рецептам)
-- заполняются только администратором
CREATE TABLE IF NOT EXISTS dictionary.GroupSettingsForTags -- todo лучше названия не придумала, пойдет?
(
    tag_group_id      BIGINT      NOT NULL,
    tag_group_name    VARCHAR(50) NOT NULL, -- Название группы тегов (Время приема пищи / Праздники / Популярные фильтры)
    is_ingredient     BOOLEAN     NOT NULL, -- Тех. настройки, чтобы понимать отображать эту группу тегов при добавлении нового продукта или нет
    is_dish           BOOLEAN     NOT NULL, -- Тех. настройки, чтобы понимать отображать эту группу тегов при добавлении нового рецепта или нет
    is_filled_by_user BOOLEAN     NOT NULL,
    is_filter         BOOLEAN     NOT NULL, -- Тех. настройки (отображать или нет в списке фильтров - поиск рецептов)
    sequence          INTEGER     NOT NULL, -- Тех. настройки (порядок отображения групп фильтров, например, поиск рецептов или создание рецепта)
    CONSTRAINT PK_TagGroupSettings PRIMARY KEY (tag_group_id),
    CONSTRAINT UQ_TagGroupSettings_tag_group_name UNIQUE (tag_group_name)
);

-- ManyToMany - связка тегов с группами
CREATE TABLE IF NOT EXISTS dictionary.TagGroup
(
    tag_group_id    BIGINT      NOT NULL,
    tag_id          BIGINT      NOT NULL,
    CONSTRAINT PK_TagType PRIMARY KEY (tag_group_id, tag_id)
);
