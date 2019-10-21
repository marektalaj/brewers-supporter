package pl.brewers.supporter.brewerssupporter.model;

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
    @OneToMany(mappedBy = "recipe")
    private final List<MaltingIngredient> maltingIngredients = new ArrayList<>();

    @Singular
    @OneToMany(mappedBy = "recipe")
    private final List<HoopingIngredient> hoopingIngredients = new ArrayList<>();

    @Singular
    @OneToMany(mappedBy = "recipe")
    private final List<AdditionalIngredient> additionalIngredients = new ArrayList<>();

    @OneToOne
    private YeastAsIngredient yeast;

    @ManyToOne
    private User author;
}
