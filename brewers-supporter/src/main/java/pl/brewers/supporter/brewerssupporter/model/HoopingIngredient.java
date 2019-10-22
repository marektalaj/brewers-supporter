package pl.brewers.supporter.brewerssupporter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
