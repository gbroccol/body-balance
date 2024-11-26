--liquibase formatted sql

--changeset gbroccol:2024-11-10--0001-create-schemas
CREATE SCHEMA IF NOT EXISTS dictionary;
CREATE SCHEMA IF NOT EXISTS food;
