package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.brewers.supporter.brewerssupporter.model.Malt;

@Repository
public interface MaltRepository extends JpaRepository<Malt, Long> {
}
