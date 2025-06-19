--liquibase formatted sql
--changeset gbroccol:2025-06-19--0016-food-recipe_step-alter

alter table food.recipe_step
    rename column step_number to number;