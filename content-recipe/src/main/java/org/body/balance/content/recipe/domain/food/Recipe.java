package org.body.balance.content.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.body.balance.content.recipe.domain.dictionary.Cuisine;
import org.body.balance.content.recipe.domain.dictionary.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private Set<Tag> tags;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps;

    @Column(nullable = false)
    private LocalDateTime createDt;

}
