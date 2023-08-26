package com.dassag.worldcupdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dassag.worldcupdashboard.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    public Country getByCountryName(String countryName);

}
