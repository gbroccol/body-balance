--liquibase formatted sql
--changeset gbroccol:2024-11-10--0003-create-tables-for-food-schema

create table food.ingredient (
    ingredient_id           VARCHAR(36)                 NOT NULL,
    name                    VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_ingredient PRIMARY KEY (ingredient_id)
);

create table food.recipe (
    recipe_id               VARCHAR(36)                 NOT NULL,
    name                    VARCHAR(255)                NOT NULL,
    description             VARCHAR(255)                NULL,
    active_cooking_time_min INTEGER                     NOT NULL,
    cooking_time_min        INTEGER                     NOT NULL,
    portion_qty             INTEGER                     NOT NULL,
    complexity              INTEGER                     NOT NULL,
    spiciness               INTEGER                     NOT NULL,
    cuisine_id              BIGINT                      NULL,
    create_dt               TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    CONSTRAINT pk_recipe PRIMARY KEY (recipe_id),
    CONSTRAINT fk_recipe__cuisine_id FOREIGN KEY (cuisine_id) REFERENCES dictionary.cuisine
);

create table food.recipe_ingredient (
    recipe_id               VARCHAR(36)         NOT NULL,
    ingredient_id           VARCHAR(36)         NOT NULL,
    unit_id                 BIGINT              NOT NULL,
    amount                  BIGINT              NULL,
    CONSTRAINT pk_recipe_ingredient PRIMARY KEY (recipe_id, ingredient_id),
    CONSTRAINT fk_recipe_ingredient__recipe_id FOREIGN KEY (recipe_id) REFERENCES food.recipe,
    CONSTRAINT fk_recipe_ingredient__ingredient_id FOREIGN KEY (ingredient_id) REFERENCES food.ingredient,
    CONSTRAINT fk_recipe_ingredient__unit_id FOREIGN KEY (unit_id) REFERENCES dictionary.unit
);

create table food.step (
    step_id                 VARCHAR(36)         NOT NULL,
    description             VARCHAR(40000)      NOT NULL,
    step_number             INTEGER             NOT NULL,
    recipe_id               VARCHAR(36)         NOT NULL,
    CONSTRAINT pk_step PRIMARY KEY (step_id),
    CONSTRAINT fk_step__recipe_id FOREIGN KEY (recipe_id) REFERENCES food.recipe
);

CREATE UNIQUE INDEX uq_step__recipe_id_step_number ON food.step (recipe_id, step_number);

create table food.recipe_tag (
    recipe_id               VARCHAR(36)         NOT NULL,
    tag_id                  BIGINT              NOT NULL,
    CONSTRAINT pk_recipe_tag PRIMARY KEY (recipe_id, tag_id),
    CONSTRAINT fk_recipe_tag__recipe_id FOREIGN KEY (recipe_id) REFERENCES food.recipe,
    CONSTRAINT fk_recipe_tag__tag_id FOREIGN KEY (tag_id) REFERENCES dictionary.tag
);
