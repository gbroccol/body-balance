package org.body.balance.content.recipe.domain.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.body.balance.content.recipe.domain.food.Recipe;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dictionary")
public class Tag {

    @Id
    private Long tagId;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Recipe> recipes;
}