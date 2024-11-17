--liquibase formatted sql
--changeset gbroccol:2024-11-10--0002-create-tables-for-dictionary-schema

create table dictionary.tag (
    tag_id          BIGINT          NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_tag PRIMARY KEY (tag_id)
);

create table dictionary.unit (
    unit_id         BIGINT          NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    short_name      VARCHAR(255)    NULL,
    CONSTRAINT pk_unit PRIMARY KEY (unit_id)
);

create table dictionary.cuisine (
    cuisine_id      BIGINT          NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_cuisine PRIMARY KEY (cuisine_id)
);