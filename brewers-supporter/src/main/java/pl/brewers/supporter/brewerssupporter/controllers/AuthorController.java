package pl.brewers.supporter.brewerssupporter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.brewers.supporter.brewerssupporter.repositories.AuthorRepository;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;




}
