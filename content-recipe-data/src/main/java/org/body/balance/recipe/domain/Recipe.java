package org.body.balance.recipe.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Field
//@DBRef
//@Transient

@Document(collection = "recipe")
@AllArgsConstructor
public class Recipe {

    @Id
    private String id; // todo название ок?

//    @Field
    private String name;

//    @Field
    private Integer cookingTimeMin;

//    @Field
    private Integer activeCookingTimeMin;

//    @Field
    private Integer portionQty;

//    @Field
//    @Size(min = 0, max = 10)
    private Integer spiciness;
}
