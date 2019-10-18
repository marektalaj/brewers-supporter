package pl.brewers.supporter.brewerssupporter.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatingService {

    public double refactometerCorrection(BigDecimal originalGravity, BigDecimal measuredGravity) {
        BigDecimal correction = BigDecimal.valueOf(1.04);

        if (originalGravity.equals(BigDecimal.valueOf(0))) {
            return Double.NaN;
        }
        BigDecimal finalSG = calculateSG(originalGravity, measuredGravity, correction);

        return finalSG.multiply(BigDecimal.valueOf(182.4601))
                .subtract(BigDecimal.valueOf(775.6821))
                .multiply(finalSG)
                .add(BigDecimal.valueOf(1262.7794))
                .multiply(finalSG)
                .subtract(BigDecimal.valueOf(669.5622)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private BigDecimal calculateSG(BigDecimal originalGravity, BigDecimal measuredGravity, BigDecimal correction) {
        return BigDecimal.valueOf(1)
                .subtract(BigDecimal.valueOf(0.004493).multiply(originalGravity.divide(correction, RoundingMode.HALF_UP)))
                .add(BigDecimal.valueOf(0.0117741).multiply(measuredGravity.divide(correction, RoundingMode.HALF_UP)))
                .add(BigDecimal.valueOf(0.000275806).multiply(originalGravity.divide(correction, RoundingMode.HALF_UP).pow(2)))
                .subtract(BigDecimal.valueOf(0.00127169).multiply(measuredGravity.divide(correction, RoundingMode.HALF_UP).pow(2)))
                .subtract(BigDecimal.valueOf(0.00000727999).multiply(originalGravity.divide(correction, RoundingMode.HALF_UP).pow(3)))
                .add(BigDecimal.valueOf(0.0000632929).multiply(measuredGravity.divide(correction, RoundingMode.HALF_UP).pow(3)));
    }

    public double wortCorrection(BigDecimal amount, BigDecimal measured, BigDecimal wanted) {
        if (measured.doubleValue() < wanted.doubleValue()) {
            return wanted.subtract(measured).multiply(BigDecimal.valueOf(11)).multiply(amount).setScale(0, RoundingMode.HALF_EVEN).doubleValue();
        } else {
            return amount.multiply(measured.subtract(wanted).divide(wanted, 2, RoundingMode.HALF_UP)).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
        }
    }

    public double alcoholCalculation(BigDecimal originalGravity, BigDecimal finalGravity) {
        return originalGravity.subtract(finalGravity).divide(BigDecimal.valueOf(1.9047619047619), RoundingMode.HALF_EVEN).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double mashEfficiency(BigDecimal amount, BigDecimal gravity, BigDecimal maltAmount) {
        return amount.multiply(gravity).multiply(BigDecimal.valueOf(1.05)).divide(maltAmount, 2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
