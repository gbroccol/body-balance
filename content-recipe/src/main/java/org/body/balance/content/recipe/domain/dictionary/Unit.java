package org.body.balance.content.recipe.domain.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.body.balance.content.recipe.domain.food.RecipeIngredient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dictionary")
public class Unit {

    @Id
    private Long unitId;

    private String name;

    private String shortName;

    @OneToMany(mappedBy = "unit")
    private Set<RecipeIngredient> recipeIngredient;
}