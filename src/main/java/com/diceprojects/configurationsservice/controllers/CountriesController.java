package com.diceprojects.configurationsservice.controllers;

import com.diceprojects.configurationsservice.persistences.models.dtos.CountrySaveDTO;
import com.diceprojects.configurationsservice.persistences.models.entities.Countries;
import com.diceprojects.configurationsservice.services.CountriesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/Countries")
public class CountriesController {

    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @PostMapping("/save")
    public Mono<Countries> saveCountry(@RequestBody @Valid CountrySaveDTO country) {
        return countriesService.saveCountry(country);
    }
}
