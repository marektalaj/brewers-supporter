package pl.brewers.supporter.brewerssupporter.services;

import org.springframework.stereotype.Service;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.dto.HoopingDataResponseDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashDataRequestDTO;
import pl.brewers.supporter.brewerssupporter.dto.MashDataResponseDTO;
import pl.brewers.supporter.brewerssupporter.model.HoopingIngredient;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatingService {
    private final BigDecimal MASH_EFFICIENCY = BigDecimal.valueOf(0.80);

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
                .subtract(BigDecimal.valueOf(0.004493).multiply(originalGravity.divide(correction, 3, RoundingMode.HALF_UP)))
                .add(BigDecimal.valueOf(0.0117741).multiply(measuredGravity.divide(correction, 3, RoundingMode.HALF_UP)))
                .add(BigDecimal.valueOf(0.000275806).multiply(originalGravity.divide(correction, 3, RoundingMode.HALF_UP).pow(2)))
                .subtract(BigDecimal.valueOf(0.00127169).multiply(measuredGravity.divide(correction, 3, RoundingMode.HALF_UP).pow(2)))
                .subtract(BigDecimal.valueOf(0.00000727999).multiply(originalGravity.divide(correction, 3, RoundingMode.HALF_UP).pow(3)))
                .add(BigDecimal.valueOf(0.0000632929).multiply(measuredGravity.divide(correction, 3, RoundingMode.HALF_UP).pow(3)));
    }

    public double wortCorrection(BigDecimal amount, BigDecimal measured, BigDecimal wanted) {
        if (measured.doubleValue() < wanted.doubleValue()) {
            return wanted.subtract(measured).multiply(BigDecimal.valueOf(11)).multiply(amount).setScale(0, RoundingMode.HALF_EVEN).doubleValue();
        } else {
            return amount.multiply(measured.subtract(wanted).divide(wanted, 2, RoundingMode.HALF_UP)).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
        }
    }

    public double alcoholCalculation(BigDecimal originalGravity, BigDecimal finalGravity) {
        return originalGravity.subtract(finalGravity).divide(BigDecimal.valueOf(1.9047619047619), 3, RoundingMode.HALF_EVEN).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
    }

    public double mashEfficiency(BigDecimal amount, BigDecimal gravity, BigDecimal maltAmount) {
        return amount.multiply(gravity).multiply(BigDecimal.valueOf(1.05)).divide(maltAmount, 2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public MashDataResponseDTO calculateMashData(MashDataRequestDTO data) {
        BigDecimal sugarAmount = data.getMaltingIngredients().stream()
                .map(ingredient -> ingredient.getAmount().multiply(ingredient.getMalt().getExtraction().multiply(MASH_EFFICIENCY).multiply(BigDecimal.valueOf(10))))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);

        return MashDataResponseDTO.builder()
                .gravity(
                        sugarAmount
                                .divide(data.getAmount().multiply(BigDecimal.valueOf(1000)).subtract(sugarAmount.divide(BigDecimal.valueOf(1.587), 3, RoundingMode.HALF_DOWN)).add(sugarAmount), 3, RoundingMode.HALF_DOWN)
                                .multiply(BigDecimal.valueOf(100))
                )
                .build();
    }

    public HoopingDataResponseDTO calculateIBU(HoopingDataRequestDTO data) {
        BigDecimal gravityConverted = convertGravity(data.getGravity());
        BigDecimal amountConverted = data.getAmount();

        return HoopingDataResponseDTO.builder()
                .ibu(
                        data.getHoopingIngredients().stream()
                                .map(hoop -> calculateHoopUsing(hoop, gravityConverted, amountConverted))
                                .reduce(BigDecimal.valueOf(0), BigDecimal::add)

                ).build();
    }

    private BigDecimal calculateHoopUsing(HoopingIngredient hoop, BigDecimal gravityConverted, BigDecimal amountConverted) {
        BigDecimal usedHoop = BigDecimal.valueOf(1.65).multiply(BigDecimal.valueOf(Math.pow(0.000125, gravityConverted.subtract(BigDecimal.valueOf(1)).doubleValue())))
                .multiply(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(Math.exp(hoop.getTime() * (BigDecimal.valueOf(-0.04).doubleValue())))).divide(BigDecimal.valueOf(4.15), 3, RoundingMode.HALF_EVEN));
        return usedHoop.multiply(hoop.getHoop().getAlphaAcid().divide(BigDecimal.valueOf(100), 3, RoundingMode.HALF_EVEN)).multiply(hoop.getAmount()).multiply(BigDecimal.valueOf(1000).divide(amountConverted, 3, RoundingMode.HALF_EVEN));
    }

    private BigDecimal convertGravity(BigDecimal gravity) {
        return BigDecimal.valueOf(260).divide(BigDecimal.valueOf(260).subtract(gravity), 3, RoundingMode.HALF_DOWN);
    }
}
