package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
public class AdditionalIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private IngredientType type;
    private BigDecimal amount;
    private BrewingProcess usedTo;
    private int time;
    @ManyToOne
    private Recipe recipe;

}
