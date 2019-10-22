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
            return originalGravity.add(finalGravity).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_EVEN);
        }
        return null;
    }

    private BigDecimal originalGravity;
    private BigDecimal finalGravity;
    private BigDecimal gravityBeforeBoiling;
    private BigDecimal amountBeforeBoiling;
    private BigDecimal amountAfterBoiling;
    private BigDecimal ibu;

    @JsonIgnore
    @ManyToOne
    private Recipe recipe;
    @JsonIgnore
    @ManyToOne
    private User author;

}
