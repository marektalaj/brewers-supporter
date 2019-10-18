package pl.brewers.supporter.brewerssupporter.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatingServiceTest {

    @InjectMocks
    private CalculatingService calculatingService;

    @Test
    public void checkIfCalculateRefactometerGravityCorrectly(){
        Assert.assertTrue(BigDecimal.valueOf(3.45).doubleValue() < calculatingService.refactometerCorrection(BigDecimal.valueOf(16.0),BigDecimal.valueOf(8.0)));
        Assert.assertTrue(BigDecimal.valueOf(3.58).doubleValue() > calculatingService.refactometerCorrection(BigDecimal.valueOf(16.0),BigDecimal.valueOf(8.0)));

        Assert.assertTrue(BigDecimal.valueOf(3.45).doubleValue() < calculatingService.refactometerCorrection(BigDecimal.valueOf(13.0),BigDecimal.valueOf(7.0)));
        Assert.assertTrue(BigDecimal.valueOf(3.55).doubleValue() > calculatingService.refactometerCorrection(BigDecimal.valueOf(13.0),BigDecimal.valueOf(7.0)));
    }

    @Test
    public void checkIfCalculateAlcoholCorrectly(){
        Assert.assertEquals(BigDecimal.valueOf(4.9).doubleValue(), calculatingService.alcoholCalculation(BigDecimal.valueOf(13.00), BigDecimal.valueOf(3.60)), 0.0);
    }

    @Test
    public void checkIfCorrectionWorks(){
        Assert.assertEquals(BigDecimal.valueOf(440).doubleValue(), calculatingService.wortCorrection(BigDecimal.valueOf(20.00), BigDecimal.valueOf(10),BigDecimal.valueOf(12)), 0.0);
        Assert.assertEquals(BigDecimal.valueOf(5).doubleValue(), calculatingService.wortCorrection(BigDecimal.valueOf(20.00), BigDecimal.valueOf(15),BigDecimal.valueOf(12)), 0.0);
    }
    @Test
    public void checkIfEfficiencyCalcWork(){
        Assert.assertEquals(BigDecimal.valueOf(63).doubleValue(), calculatingService.mashEfficiency(BigDecimal.valueOf(20.00), BigDecimal.valueOf(12),BigDecimal.valueOf(4)), 0.1);
    }
}