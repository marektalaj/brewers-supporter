package pl.brewers.supporter.brewerssupporter.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BrewingParamsDTO {
    private BigDecimal gravityBeforeBoiling;
    private BigDecimal originalGravity;
    private BigDecimal amountBeforeBoiling;
    private BigDecimal amount;
    private String notes;

}
