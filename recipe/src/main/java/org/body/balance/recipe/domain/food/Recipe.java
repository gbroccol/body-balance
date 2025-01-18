package org.body.balance.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.body.balance.recipe.domain.dictionary.Cuisine;
import org.body.balance.recipe.domain.dictionary.Tag;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class Recipe {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeId;

    private String name;

    private String description;

    private Integer cookingTimeMin;

    private Integer activeCookingTimeMin;

    private Integer portionQty;

    private Integer complexity;

    private Integer spiciness;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @ManyToMany
    @JoinTable(
            name = "recipe_tag",
            schema = "food",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps = new ArrayList<>();

    private LocalDateTime deleteDt;

    private final UUID ownerId = UUID.fromString("fdd3c0c5-01ee-4cc6-8d86-ce47c7a4b57a"); // todo убрать хардкод
}
