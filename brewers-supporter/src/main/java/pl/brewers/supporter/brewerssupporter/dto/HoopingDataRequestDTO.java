package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;
import pl.brewers.supporter.brewerssupporter.model.HoopingIngredient;

import java.util.List;

@Data
@Builder
public class HoopingDataRequestDTO {
    private double gravity;
    private double amount;
    private List<HoopingIngredient> hoopingIngredients;
}
