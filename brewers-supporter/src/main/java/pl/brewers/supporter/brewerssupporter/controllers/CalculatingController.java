package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.dto.*;
import pl.brewers.supporter.brewerssupporter.services.CalculatingService;
import pl.brewers.supporter.brewerssupporter.services.HoopingDataRequestDTO;

import java.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping("calculator/")
@RequiredArgsConstructor
public class CalculatingController {

    private final CalculatingService calculatingService;

    @PostMapping(value = "refactometer")
    public double refactometerCorrection(@RequestBody RefactometerCalculationDTO data) {
        return calculatingService.refactometerCorrection(BigDecimal.valueOf(data.getOriginalGravity()), BigDecimal.valueOf(data.getMeasuredGravity()));
    }

    @PostMapping(value = "correction")
    public double wortCorrection(@RequestBody WortCorrectionDTO data) {
        return calculatingService.wortCorrection(BigDecimal.valueOf(data.getAmount()), BigDecimal.valueOf(data.getMeasured()), BigDecimal.valueOf(data.getWanted()));
    }

    @PostMapping(value = "alcohol")
    public double alcoholCalculation(@RequestBody AlcoholCalculationDTO data) {
        return calculatingService.alcoholCalculation(BigDecimal.valueOf(data.getOriginalGravity()), BigDecimal.valueOf(data.getFinalGravity()));
    }

    @PostMapping(value = "efficiency")
    public double mashEfficiency(@RequestBody MashEfficiencyDTO data) {
        return calculatingService.mashEfficiency(BigDecimal.valueOf(data.getAmount()), BigDecimal.valueOf(data.getGravity()), BigDecimal.valueOf(data.getMaltAmount()));
    }

    @PostMapping(value = "mash")
    public MashDataResponseDTO mashData(@RequestBody MashDataRequestDTO data) {
        return calculatingService.calculateMashData(data);
    }

    @PostMapping(value = "ibu")
    public HoopingDataResponseDTO mashData(@RequestBody HoopingDataRequestDTO data) {
        return calculatingService.calculateIBU(data);
    }
}
