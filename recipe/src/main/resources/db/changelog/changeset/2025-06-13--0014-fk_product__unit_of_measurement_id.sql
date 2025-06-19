--liquibase formatted sql
--changeset gbroccol:2025-06-13--0014-fk_product__unit_of_measurement_id

alter table food.product
    add constraint fk_product__unit_of_measurement_id
        foreign key (unit_of_measurement_id) references dictionary.unit_of_measurement;

create table food.recipe_comment
(
    recipe_id  uuid          not null,
    user_id    uuid          not null,
    text       varchar(1024) not null,
    created_at timestamptz   not null default now()
);
