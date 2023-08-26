package com.dassag.worldcupdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dassag.worldcupdashboard.model.Match;
import com.dassag.worldcupdashboard.repository.MatchRepository;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping(value = "/{year}", produces = { "application/json" })
    public List<Match> getAllMatchOfTheYear(@PathVariable Long year) {
        return matchRepository.getMatchByYearOrderByDateDesc(year);
    }

    @GetMapping(value = "/{year}/{id}", produces = { "application/json" })
    public Match getMatch(@PathVariable Long year, @PathVariable Long id) {
        return matchRepository.getMatchByYearAndId(year, id);
    }

}
