package pl.brewers.supporter.brewerssupporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.brewers.supporter.brewerssupporter.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@SpringBootApplication
public class BrewersSupporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrewersSupporterApplication.class, args);
    }

}
