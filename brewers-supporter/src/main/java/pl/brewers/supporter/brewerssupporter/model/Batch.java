package pl.brewers.supporter.brewerssupporter.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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
    private BigDecimal alcoholByVolume;

    @PrePersist
    private void calculateAlcohol() {
        if (finalGravity != null && originalGravity != null) {
            this.alcoholByVolume = originalGravity.subtract(finalGravity).divide(BigDecimal.valueOf(1.938), 2, RoundingMode.HALF_EVEN);
        }
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
