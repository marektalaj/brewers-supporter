package pl.brewers.supporter.brewerssupporter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String notes;
    private BigDecimal amount;
    private BigDecimal originalGravity;
    private BigDecimal ibu;
    private ZonedDateTime creationDateTime;
    private ZonedDateTime lastEditDateTime;

    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private final List<MaltingStage> maltingStages = new ArrayList<>();

    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private final List<MaltingIngredient> maltingIngredients = new ArrayList<>();

    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private final List<HoopingIngredient> hoopingIngredients = new ArrayList<>();

    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private final List<AdditionalIngredient> additionalIngredients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private YeastAsIngredient yeast;

    @Singular
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private final List<Batch> batches = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private User author;
}
