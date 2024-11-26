--liquibase formatted sql
--changeset gbroccol:2024-11-26--0009-alter-tbl

alter table food.recipe ADD COLUMN delete_dt TIMESTAMP WITH TIME ZONE NULL;