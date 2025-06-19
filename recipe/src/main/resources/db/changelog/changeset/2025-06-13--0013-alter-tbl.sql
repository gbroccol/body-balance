--liquibase formatted sql
--changeset gbroccol:2025-06-13--0013-alter-tbl

alter table food.product alter column unit_of_measurement set not null;
alter table food.product alter column created_by set not null;

alter table food.recipe rename column name to title;

alter table food.recipe add column calories decimal(6,2); -- ['Калории на 100 г']
alter table food.recipe add column proteins decimal(6,2); -- ['Белки на 100 г']
alter table food.recipe add column fats decimal(6,2); -- ['Жиры на 100 г']
alter table food.recipe add column carbohydrates decimal(7,2); -- ['Углеводы на 100 г']
alter table food.recipe add column photo_url varchar(512); -- ['URL главной фотографии - ссылка на файловое хранилище']
alter table food.recipe add column status varchar(12) not null default 'New'; -- 'Все рецепты проходят модерацию, прежде чем быть опубликованными. Статусы: новый, опубликован, архивирован (доступен автору, недоступен пользователям), удалён'
alter table food.recipe add column is_public boolean not null default true; -- 'Виден ли рецепт другим пользователям'

alter table food.step alter column description type varchar(1024) using description::varchar(1024);
alter table food.step add column photo_url varchar(512);
alter table food.step rename to recipe_step;

alter table dictionary.unit rename to unit_of_measurement;

alter table food.recipe_ingredient rename column ingredient_id to product_id;
alter table food.recipe_ingredient rename column unit_id to unit_of_measurement_id;
alter table food.recipe_ingredient rename column amount to quantity;
alter table food.product rename column unit_of_measurement to unit_of_measurement_id;
alter table food.recipe rename column create_dt to created_at;
alter table food.recipe rename column delete_dt to deleted_at;

create table recipe_comment
(
    recipe_id  uuid          not null,
    user_id    uuid          not null,
    text       varchar(1024) not null,
    created_at timestamptz   not null default now()
);

