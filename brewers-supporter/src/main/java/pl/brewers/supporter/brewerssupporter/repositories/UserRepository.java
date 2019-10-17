package pl.brewers.supporter.brewerssupporter.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.brewers.supporter.brewerssupporter.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}