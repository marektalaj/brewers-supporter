package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.brewers.supporter.brewerssupporter.model.Yeast;

@Repository
public interface YeastRepository extends JpaRepository<Yeast, Long> {
}
