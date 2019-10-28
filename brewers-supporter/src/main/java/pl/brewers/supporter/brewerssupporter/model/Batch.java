package pl.brewers.supporter.brewerssupporter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime brewingDate;
    private int fermentationTime;
    private String notes;
    private BigDecimal alcoholByVolume = calculateAlcohol();

    private BigDecimal calculateAlcohol() {
        if (finalGravity != null && originalGravity != null) {
            return originalGravity.subtract(finalGravity).divide(BigDecimal.valueOf(1.938), 2, RoundingMode.HALF_EVEN);
        }
        return null;
    }

    private BigDecimal originalGravity;
    private BigDecimal finalGravity;
    private BigDecimal gravityBeforeBoiling;
    private BigDecimal amountBeforeBoiling;
    private BigDecimal amountAfterBoiling;
    private BigDecimal ibu;

    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private User author;

}
