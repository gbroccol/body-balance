package org.body.balance.recipe.domain.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.body.balance.recipe.domain.food.Recipe;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dictionary")
public class Cuisine {

    @Id
    private Long cuisineId;

    private String name;

    @OneToMany(mappedBy = "cuisine")
    private Set<Recipe> recipes;
}
