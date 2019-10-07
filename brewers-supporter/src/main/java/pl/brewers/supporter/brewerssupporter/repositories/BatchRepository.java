package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.brewers.supporter.brewerssupporter.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {
}
