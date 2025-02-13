--liquibase formatted sql
--changeset gbroccol:2024-11-17--0007-fill-table-food-recipe
INSERT INTO food.recipe (recipe_id,
                            name,
                            description,
                            active_cooking_time_min,
                            cooking_time_min,
                            portion_qty,
                            complexity,
                            spiciness,
                            cuisine_id,
                            create_dt)
VALUES ('6428a40b-ffb6-4218-b21f-acbb6a0a4f75', 'Паста с курицей и грибами в сливочном соусе', null, 45, 45, 4, 3, 0, 2, now());
