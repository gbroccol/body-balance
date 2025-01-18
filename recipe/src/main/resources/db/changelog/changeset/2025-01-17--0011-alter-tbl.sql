--liquibase formatted sql
--changeset gbroccol:2025-01-17--0011-alter-tbl

alter table food.recipe add column if not exists owner_id uuid not null default 'fdd3c0c5-01ee-4cc6-8d86-ce47c7a4b57a';
alter table food.recipe alter column owner_id drop default;
