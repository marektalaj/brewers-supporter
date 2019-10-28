package pl.brewers.supporter.brewerssupporter.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataResponseDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashDataResponseDTO;
import pl.brewers.supporter.brewerssupporter.model.Hoop;
import pl.brewers.supporter.brewerssupporter.model.HoopingIngredient;
import pl.brewers.supporter.brewerssupporter.model.Malt;
import pl.brewers.supporter.brewerssupporter.model.MaltingIngredient;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatingServiceTest {

    @InjectMocks
    private CalculatingService calculatingService;

    @Test
    public void checkIfCalculateRefactometerGravityCorrectly() {
        Assert.assertEquals(BigDecimal.valueOf(3.5).doubleValue(), calculatingService.refactometerCorrection(BigDecimal.valueOf(13.00), BigDecimal.valueOf(7.0)), 0.1);
        Assert.assertEquals(BigDecimal.valueOf(3.5).doubleValue(), calculatingService.refactometerCorrection(BigDecimal.valueOf(16.00), BigDecimal.valueOf(8.0)), 0.1);
    }

    @Test
    public void checkIfCalculateAlcoholCorrectly() {
        Assert.assertEquals(BigDecimal.valueOf(4.9).doubleValue(), calculatingService.alcoholCalculation(BigDecimal.valueOf(13.00), BigDecimal.valueOf(3.60)), 0.0);
    }

    @Test
    public void checkIfCorrectionWorks() {
        Assert.assertEquals(BigDecimal.valueOf(440).doubleValue(), calculatingService.wortCorrection(BigDecimal.valueOf(20.00), BigDecimal.valueOf(10), BigDecimal.valueOf(12)), 0.0);
        Assert.assertEquals(BigDecimal.valueOf(5).doubleValue(), calculatingService.wortCorrection(BigDecimal.valueOf(20.00), BigDecimal.valueOf(15), BigDecimal.valueOf(12)), 0.0);
    }

    @Test
    public void checkIfEfficiencyCalcWork() {
        Assert.assertEquals(BigDecimal.valueOf(63).doubleValue(), calculatingService.mashEfficiency(BigDecimal.valueOf(20.00), BigDecimal.valueOf(12), BigDecimal.valueOf(4)), 0.1);
    }

    @Test
    public void checkCalculationMash() {
        MashDataRequestDTO request = MashDataRequestDTO.builder()
                .amount(BigDecimal.valueOf(24.2))
                .maltingIngredients(List.of(
                        buildMaltingIngredient(BigDecimal.valueOf(7), BigDecimal.valueOf(82.5), BigDecimal.valueOf(2.8))
                        )
                )
                .build();
        MashDataResponseDTO response = MashDataResponseDTO.builder().gravity(BigDecimal.valueOf(17.8)).build();
        Assert.assertEquals(response.getGravity().doubleValue(), calculatingService.calculateMashData(request).getGravity().doubleValue(), 0.2);
    }

    @Test
    public void checkCalculationMashWithMultipleIngredients() {
        MashDataRequestDTO request = MashDataRequestDTO.builder()
                .amount(BigDecimal.valueOf(24.2))
                .maltingIngredients(List.of(
                        buildMaltingIngredient(BigDecimal.valueOf(4), BigDecimal.valueOf(82.5), BigDecimal.valueOf(2.8)),
                        buildMaltingIngredient(BigDecimal.valueOf(0.32), BigDecimal.valueOf(81.6), BigDecimal.valueOf(6.25)),
                        buildMaltingIngredient(BigDecimal.valueOf(2.15), BigDecimal.valueOf(82.6), BigDecimal.valueOf(4))
                        )
                )
                .build();
        MashDataResponseDTO response = MashDataResponseDTO.builder().gravity(BigDecimal.valueOf(16.6)).build();
        Assert.assertEquals(response.getGravity().doubleValue(), calculatingService.calculateMashData(request).getGravity().doubleValue(), 0.2);
    }


    private MaltingIngredient buildMaltingIngredient(BigDecimal amount, BigDecimal extraction, BigDecimal ebc) {
        return MaltingIngredient.builder()
                .amount(amount)
                .malt(Malt.builder()
                        .extraction(extraction)
                        .ebc(ebc)
                        .type("Pilznenski")
                        .build())
                .build();

    }

    @Test
    public void checkCalculationIbuWithMultipleIngredients() {
        HoopingDataRequestDTO request = HoopingDataRequestDTO.builder()
                .amount(BigDecimal.valueOf(20.0))
                .gravity(BigDecimal.valueOf(14))
                .hoopingIngredients(List.of(
                        buildHoopingIngredient(BigDecimal.valueOf(15), 60, BigDecimal.valueOf(10)),
                        buildHoopingIngredient(BigDecimal.valueOf(10), 50, BigDecimal.valueOf(3)),
                        buildHoopingIngredient(BigDecimal.valueOf(20), 5, BigDecimal.valueOf(3.5))
                        )
                )
                .build();
        HoopingDataResponseDTO response = HoopingDataResponseDTO.builder().ibu(BigDecimal.valueOf(20.9)).build();
        Assert.assertEquals(response.getIbu().doubleValue(), calculatingService.calculateIBU(request).getIbu().doubleValue(), 0.2);
    }

    private HoopingIngredient buildHoopingIngredient(BigDecimal amount, int time, BigDecimal alphaAcid) {
        return HoopingIngredient.builder()
                .amount(amount)
                .time(time)
                .hoop(Hoop.builder()
                        .alphaAcid(alphaAcid)
                        .build())
                .build();

    }
}