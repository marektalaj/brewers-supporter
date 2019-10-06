package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private BigDecimal alcoholByVolume;
    private BigDecimal originalGravity;
    private BigDecimal finalGravity;
    private BigDecimal gravityBeforeBoiling;
    private BigDecimal attenuation;
    private int amountBeforeBoiling;

    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Author author;
}
