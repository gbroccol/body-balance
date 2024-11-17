package org.body.balance.content.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String step_id;

    private Integer stepNumber;

    @Column(length = 40000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}