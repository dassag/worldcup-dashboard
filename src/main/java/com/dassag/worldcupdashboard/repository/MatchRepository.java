package com.dassag.worldcupdashboard.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dassag.worldcupdashboard.model.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    public List<Match> getMatchByYearOrderByDateDesc(Long year);

    public Match getMatchByYearAndId(Long year, Long id);

}
