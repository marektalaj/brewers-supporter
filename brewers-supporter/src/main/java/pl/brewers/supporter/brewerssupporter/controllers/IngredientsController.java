package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.model.Hoop;
import pl.brewers.supporter.brewerssupporter.model.Malt;
import pl.brewers.supporter.brewerssupporter.model.Yeast;
import pl.brewers.supporter.brewerssupporter.repositories.HoopRepository;
import pl.brewers.supporter.brewerssupporter.repositories.MaltRepository;
import pl.brewers.supporter.brewerssupporter.repositories.YeastRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {
    private final MaltRepository maltRepository;
    private final HoopRepository hoopRepository;
    private final YeastRepository yeastRepository;


    @GetMapping("/malts")
    public List<Malt> getMalts(){
        return maltRepository.findAll();
    }

    @GetMapping("/hoops")
    public List<Hoop> getHoops(){
        return hoopRepository.findAll();
    }

    @GetMapping("/yeasts")
    public List<Yeast> getYeasts(){
        return yeastRepository.findAll();
    }

}

