package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Builder
public class YeastAsIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Yeast yeast;
    @OneToOne
    private Recipe recipe;
}
