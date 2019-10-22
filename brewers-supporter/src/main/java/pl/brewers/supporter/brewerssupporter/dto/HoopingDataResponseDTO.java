package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HoopingDataResponseDTO {
    private BigDecimal ibu;
}
