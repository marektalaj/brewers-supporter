package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import pl.brewers.supporter.brewerssupporter.model.MaltingIngredient;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class MashDataRequestDTO {
    private BigDecimal amount;
    private List<MaltingIngredient> maltingIngredients;
}
