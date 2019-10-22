package pl.brewers.supporter.brewerssupporter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
    private ZonedDateTime creationDateTime;
    private ZonedDateTime lastEditDateTime;

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

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private User author;
}
