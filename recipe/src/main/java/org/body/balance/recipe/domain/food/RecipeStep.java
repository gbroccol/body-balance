package org.body.balance.recipe.domain.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.body.balance.recipe.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "food")
public class RecipeStep extends BaseEntity { // todo при обновлении step должен меняться - удаление - изменение - шагов может стать меньше -- можно удаление делать через отдельную api

    private Integer number;

    @Column(length = 1024)
    private String text;

    @Column(length = 512)
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}