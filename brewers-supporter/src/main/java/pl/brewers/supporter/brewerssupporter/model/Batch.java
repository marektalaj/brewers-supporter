package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime brewingDate;
    private int fermentationTime;
    private String notes;
    private BigDecimal alcoholByVolume = calculateAlcohol();

    private BigDecimal calculateAlcohol() {
        if(finalGravity != null && originalGravity!= null) {
            return originalGravity.add(finalGravity).divide(BigDecimal.valueOf(2));
        }
        return null;
    }

    private BigDecimal originalGravity;
    private BigDecimal finalGravity;
    private BigDecimal gravityBeforeBoiling;
    private BigDecimal attenuation;
    private BigDecimal amountBeforeBoiling;

    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Author author;
}
