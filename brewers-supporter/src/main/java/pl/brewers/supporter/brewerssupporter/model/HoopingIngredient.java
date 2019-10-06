package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data
@Builder
public class HoopingIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int time;
    private int amount;
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Hoop hoop;
}
