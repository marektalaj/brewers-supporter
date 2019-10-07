package pl.brewers.supporter.brewerssupporter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;
    private String login;
    private String email;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Recipe> recipes;
    @OneToMany(mappedBy = "author")
    private List<Recipe> batches;
}
