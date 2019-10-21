package pl.brewers.supporter.brewerssupporter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.brewers.supporter.brewerssupporter.model.Hoop;
import pl.brewers.supporter.brewerssupporter.model.HoopType;
import pl.brewers.supporter.brewerssupporter.model.Malt;
import pl.brewers.supporter.brewerssupporter.model.Yeast;
import pl.brewers.supporter.brewerssupporter.model.YeastType;
import pl.brewers.supporter.brewerssupporter.repositories.HoopRepository;
import pl.brewers.supporter.brewerssupporter.repositories.MaltRepository;
import pl.brewers.supporter.brewerssupporter.repositories.YeastRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MaltRepository maltRepository;
    private final HoopRepository hoopRepository;
    private final YeastRepository yeastRepository;

    public void run(ApplicationArguments args) {
        maltRepository.save(buildMalt("pszeniczny",80.00));
        maltRepository.save(buildMalt("monachijski",85.00));
        maltRepository.save(buildMalt("pale ale",90.00));
        hoopRepository.save(buildHoop("iunga",12.00));
        hoopRepository.save(buildHoop("lubelski",9.00));
        hoopRepository.save(buildHoop("marynka",7.00));
        yeastRepository.save(buildYeasts("S-04"));
        yeastRepository.save(buildYeasts("US-05"));
    }

    private Yeast buildYeasts(String name) {
        return Yeast.builder()
                .name(name)
                .type(YeastType.SUCHE)
                .country("us")
                .build();
    }

    private Hoop buildHoop(String name, double aminokwasy) {
        return Hoop.builder()
                .name(name)
                .country("polska")
                .type(HoopType.AROMATYCZNY)
                .aminokwasy(BigDecimal.valueOf(aminokwasy))
                .build();
    }

    private Malt buildMalt(String type, double extraction) {
        return Malt.builder()
                .type(type)
                .producer("viking malt")
                .country("polska")
                .extraction(BigDecimal.valueOf(extraction))
                .ebc(BigDecimal.valueOf(10))
                .build();
    }
}
