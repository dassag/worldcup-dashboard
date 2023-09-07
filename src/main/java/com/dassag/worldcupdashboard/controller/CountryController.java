package com.dassag.worldcupdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dassag.worldcupdashboard.model.Country;
import com.dassag.worldcupdashboard.repository.CountryRepository;

@RestController
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return (List) countryRepository.findAll();
    }

    @GetMapping("country/{countryName}")
    public Country getByName(@PathVariable String countryName) {
        return countryRepository.getByCountryNameIgnoreCase(countryName);
    }

}
