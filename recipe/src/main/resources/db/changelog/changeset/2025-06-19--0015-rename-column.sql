--liquibase formatted sql
--changeset gbroccol:2025-06-19--0015-rename-column

alter table food.recipe_step
    rename column description to text;
