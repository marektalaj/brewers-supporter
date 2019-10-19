package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.dto.AlcoholCalculationDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashEfficiencyDTO;
import pl.brewers.supporter.brewerssupporter.dto.RefactometerCalculationDTO;
import pl.brewers.supporter.brewerssupporter.dto.WortCorrectionDTO;
import pl.brewers.supporter.brewerssupporter.services.CalculatingService;

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
}
