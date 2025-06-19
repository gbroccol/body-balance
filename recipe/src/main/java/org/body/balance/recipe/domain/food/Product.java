package org.body.balance.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.body.balance.recipe.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class Product extends BaseEntity {

    private String name;

//    todo add fields

    @OneToMany(mappedBy = "product")
    private Set<RecipeIngredient> recipeIngredients;

    public Product(UUID id) { // todo проверить нужен? для сохранения рецепта добавляла
        super(id);
    }
}