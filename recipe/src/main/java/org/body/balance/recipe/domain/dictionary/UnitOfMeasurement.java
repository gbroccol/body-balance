package org.body.balance.recipe.domain.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.body.balance.recipe.domain.food.RecipeIngredient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dictionary")
public class UnitOfMeasurement {

    @Id
    private Long id;

    private String name;

    private String shortName;

    @OneToMany(mappedBy = "unitOfMeasurement")
    private Set<RecipeIngredient> recipeIngredient;
}