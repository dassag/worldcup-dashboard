package com.dassag.worldcupdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dassag.worldcupdashboard.model.Match;
import com.dassag.worldcupdashboard.repository.MatchRepository;

@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping(value = "match/{year}", produces = { "application/json" })
    public List<Match> getAllMatchOfTheYear(@PathVariable Long year) {
        return matchRepository.getMatchByYearOrderByDateDesc(year);
    }

    @GetMapping(value = "match/{year}/{id}", produces = { "application/json" })
    public Match getMatch(@PathVariable Long year, @PathVariable Long id) {
        return matchRepository.getMatchByYearAndId(year, id);
    }

}
