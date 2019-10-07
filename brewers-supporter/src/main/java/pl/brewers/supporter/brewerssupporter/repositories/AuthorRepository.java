package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.brewers.supporter.brewerssupporter.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
