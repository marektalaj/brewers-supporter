package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Builder
public class HoopingIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int time;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Hoop hoop;
}
