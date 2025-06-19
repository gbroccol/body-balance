--liquibase formatted sql
--changeset gbroccol:2025-06-12--0012-alter-tbl

-- del constraints
alter table food.recipe_ingredient drop constraint fk_recipe_ingredient__recipe_id;
alter table food.recipe_ingredient drop constraint fk_recipe_ingredient__ingredient_id;
alter table food.recipe_ingredient drop constraint fk_recipe_ingredient__unit_id;
alter table food.recipe drop constraint fk_recipe__cuisine_id;
alter table food.recipe_tag drop constraint fk_recipe_tag__recipe_id;
alter table food.recipe_tag drop constraint fk_recipe_tag__tag_id;
alter table food.step drop constraint fk_step__recipe_id;

-- change data types
ALTER TABLE food.recipe ALTER COLUMN recipe_id SET DATA TYPE UUID USING recipe_id::uuid;
ALTER TABLE food.ingredient ALTER COLUMN ingredient_id SET DATA TYPE UUID USING ingredient_id::uuid;
ALTER TABLE food.recipe_ingredient ALTER COLUMN recipe_id SET DATA TYPE UUID USING recipe_id::uuid;
ALTER TABLE food.recipe_ingredient ALTER COLUMN ingredient_id SET DATA TYPE UUID USING ingredient_id::uuid;
ALTER TABLE food.recipe_tag ALTER COLUMN recipe_id SET DATA TYPE UUID USING recipe_id::uuid;
ALTER TABLE food.step ALTER COLUMN step_id SET DATA TYPE UUID USING step_id::uuid;
ALTER TABLE food.step ALTER COLUMN recipe_id SET DATA TYPE UUID USING recipe_id::uuid;

-- add constraints
alter table food.recipe_ingredient
    add constraint fk_recipe_ingredient__recipe_id
        foreign key (recipe_id) references food.recipe;

alter table food.recipe_ingredient
    add constraint fk_recipe_ingredient__ingredient_id
        foreign key (ingredient_id) references food.ingredient;

alter table food.recipe_ingredient
    add constraint fk_recipe_ingredient__unit_id
        foreign key (unit_id) references dictionary.unit;

alter table food.recipe
    add constraint fk_recipe__cuisine_id
        foreign key (cuisine_id) references dictionary.cuisine;

alter table food.recipe_tag
    add constraint fk_recipe_tag__recipe_id
        foreign key (recipe_id) references food.recipe;

alter table food.recipe_tag
    add constraint fk_recipe_tag__tag_id
        foreign key (tag_id) references dictionary.tag;

alter table food.step
    add constraint fk_step__recipe_id
        foreign key (recipe_id) references food.recipe;

-- rename id
alter table dictionary.cuisine rename column cuisine_id to id;
alter table dictionary.tag rename column tag_id to id;
alter table dictionary.unit rename column unit_id to id;
alter table food.ingredient rename column ingredient_id to id;
alter table food.recipe rename column recipe_id to id;
alter table food.step rename column step_id to id;

-- add new columns into food.ingredient
alter table food.ingredient add column calories decimal(6,2); -- [note: 'Калории на 100 г']
alter table food.ingredient add column proteins decimal(6,2); -- [note: 'Белки на 100 г']
alter table food.ingredient add column fats decimal(6,2); -- [note: 'Жиры на 100 г']
alter table food.ingredient add column carbohydrates decimal(7,2); -- [note: 'Углеводы на 100 г']
alter table food.ingredient add column unit_of_measurement integer null; --note: 'Единица измерения, справочник: 0 - граммы, 1 - миллилитры']
alter table food.ingredient add column created_by uuid null; --note: 'Пользователь, добавивший продукт (если из справочника, может быть системным)']
alter table food.ingredient add column created_at timestamptz not null default now(); --note: 'Дата добавления продукта']
alter table food.ingredient add column is_archived boolean not null default false; -- note: 'Доступен ли продукт пользователям в поиске. Если продукт удаляют, то он остается в рецептах, но больше недоступен для добавления другими пользователям']
alter table food.ingredient rename to product;

