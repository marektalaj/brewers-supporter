package pl.brewers.supporter.brewerssupporter.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "\"User\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    @OneToMany
    private List<Recipe> recipes;
    @OneToMany
    private List<Batch> batches;
}
