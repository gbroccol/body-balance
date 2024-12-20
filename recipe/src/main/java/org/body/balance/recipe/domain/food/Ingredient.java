package org.body.balance.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor // todo будем выносить в общий класс?
@AllArgsConstructor
@Table(schema = "food") // todo обдумать возможно dictionary
public class Ingredient {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String ingredientId;

    private String name;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients;

}