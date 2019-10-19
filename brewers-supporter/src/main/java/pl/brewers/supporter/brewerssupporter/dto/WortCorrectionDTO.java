package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Data;

@Data
public class WortCorrectionDTO {
    private double amount;
    private double measured;
    private double wanted;
}
