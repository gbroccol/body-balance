package org.body.balance.recipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.body.balance.recipe.config.logging.MonitoringConstants;
import org.body.balance.recipe.domain.dictionary.UnitOfMeasurement;
import org.body.balance.recipe.domain.food.Product;
import org.body.balance.recipe.domain.food.Recipe;
import org.body.balance.recipe.domain.food.RecipeIngredient;
import org.body.balance.recipe.dto.request.RecipeRequestDto;
import org.body.balance.recipe.dto.response.RecipeResponseDto;
import org.body.balance.recipe.exception.ProductIdDoesNotExistsException;
import org.body.balance.recipe.exception.UnitOfMeasurementIdDoesNotExistsException;
import org.body.balance.recipe.mapper.RecipeMapper;
import org.body.balance.recipe.repository.ProductRepository;
import org.body.balance.recipe.repository.RecipeRepository;
import org.body.balance.recipe.repository.UnitOfMeasurementRepository;
import org.body.balance.recipe.sender.DataSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class RecipeCreateUpdateService {

    private final RecipeRepository repository;
    private final ProductRepository productRepository;
    private final UnitOfMeasurementRepository unitOfMeasurementRepository;
    private final RecipeMapper recipeMapper;
    private final DataSender dataSender;
    private final ObjectMapper om;

    public RecipeResponseDto handleRequest(RecipeRequestDto dto) throws JsonProcessingException {

//        for (RecipeIngredientRequestDto ingr : dto.ingredients()) {
//            if (!ingredientRepository.existsById(ri.id())) {
//                throw new ProductIdDoesNotExistsException("ProductIdDoesNotExistsException"); // todo text
//            }
//            if (!unitOfMeasurementRepository.existsById(ri.unitId())) {
//                throw new UnitOfMeasurementIdDoesNotExistsException("UnitOfMeasurementIdDoesNotExistsException"); // todo text
//            }

//            UUID productId = ingr.id();
//            Long unitId = ingr.unitId();
//
//            Product product = productRepository.findById(productId)
//                    .orElseThrow(() -> new ProductIdDoesNotExistsException("Продукт не найден"));
//
//            UnitOfMeasurement unit = unitOfMeasurementRepository.findById(unitId)
//                    .orElseThrow(() -> new UnitOfMeasurementIdDoesNotExistsException("Единица измерения не найдена"));
//
//            System.out.println(product);
//            System.out.println(unit);
//        }


        Recipe recipe = recipeMapper.toEntity(dto);

        for (RecipeIngredient ingredient : recipe.getIngredients()) {
            UUID productId = ingredient.getId().getProductId();
            Long unitId = ingredient.getUnitOfMeasurement().getId();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ProductIdDoesNotExistsException("Продукт не найден"));

            UnitOfMeasurement unit = unitOfMeasurementRepository.findById(unitId)
                    .orElseThrow(() -> new UnitOfMeasurementIdDoesNotExistsException("Единица измерения не найдена"));
//
//            RecipeIngredient ingredient = new RecipeIngredient();
//            ingredient.setProduct(product);
//            ingredient.setUnitOfMeasurement(unit);
////            ingredient.setQuantity(dto.getQuantity());
////            ingredient.setId(new RecipeIngredientId(null, productId)); // recipeId заполнишь позже
////            ingredient.setRecipe(recipe);
//

//            Product product = productRepository.findById(productId)
//                    .orElseThrow(() -> new NotFoundException("Продукт не найден"));
//
//            UnitOfMeasurement unit = unitRepository.findById(unitId)
//                    .orElseThrow(() -> new NotFoundException("Ед. изм. не найдена"));

            ingredient.setProduct(product); // теперь Hibernate знает, что это managed entity // todo если заработает, попробовать заменить на Product product = entityManager.getReference(Product.class, productId);
            ingredient.setUnitOfMeasurement(unit);

            // todo проверить что в мапперах не создается new Product или UnitOfMeasurement

        }

//        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
//            recipeIngredient.setProduct(ingredientRepository.getById(recipeIngredient.getId().getIngredientId())); // todo обработать, если не сущ-ет ингредиент productId
//        }
        recipe = repository.save(recipe);

//        dataSender.send(om.writeValueAsString(
//                new RecipeCreatedEvent(getGeneralId(), recipe.getId(), recipe.getName(), recipe.getOwnerId().toString()))); // todo mapstruct

        return recipeMapper.toRecipeResponseDto(recipe);
    }

    private String getGeneralId() {
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder
                .currentRequestAttributes()
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        return (String) request.getAttribute(MonitoringConstants.HEADER_GENERAL_ID);
    }
}