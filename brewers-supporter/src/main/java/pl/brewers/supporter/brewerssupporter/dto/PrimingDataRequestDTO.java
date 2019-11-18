package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Data;

@Data
public class PrimingDataRequestDTO {
    private double carbonDioxide;
    private double amount;
    private double temperature;
}