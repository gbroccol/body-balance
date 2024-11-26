--liquibase formatted sql
--changeset gbroccol:2024-11-26--0009-alter-tbl

alter table food.recipe ADD CONSTRAINT unq_recipe UNIQUE (name);
alter table food.ingredient alter column ingredient_id SET DEFAULT gen_random_uuid();
alter table food.ingredient ADD CONSTRAINT unq_ingredient UNIQUE (name);