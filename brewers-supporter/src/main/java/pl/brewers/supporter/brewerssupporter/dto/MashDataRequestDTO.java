package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;
import pl.brewers.supporter.brewerssupporter.model.MaltingIngredient;

import java.util.List;

@Data
@Builder
public class MashDataRequestDTO {
    private double amount;
    private List<MaltingIngredient> maltingIngredients;
}
