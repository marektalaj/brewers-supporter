package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MashDataResponseDTO {
    private BigDecimal gravity;
}
