package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;
import pl.brewers.supporter.brewerssupporter.model.HoopingIngredient;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class HoopingDataRequestDTO {
    private BigDecimal gravity;
    private BigDecimal amount;
    private List<HoopingIngredient> hoopingIngredients;
}
