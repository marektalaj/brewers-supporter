package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MashDataResponseDTO {
    private double gravity;
}