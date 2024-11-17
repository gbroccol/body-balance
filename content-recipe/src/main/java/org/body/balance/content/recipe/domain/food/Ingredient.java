package org.body.balance.content.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor // todo будем выносить в общий класс?
@AllArgsConstructor
@Table(schema = "food") // todo обдумать возможно dictionary
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ingredientId;

    private String name;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients;

}