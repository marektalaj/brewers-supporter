package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.brewers.supporter.brewerssupporter.model.Batch;
import pl.brewers.supporter.brewerssupporter.model.User;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByAuthor(User author);
}
