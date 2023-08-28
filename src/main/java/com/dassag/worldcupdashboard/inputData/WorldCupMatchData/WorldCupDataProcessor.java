package com.dassag.worldcupdashboard.inputData.WorldCupMatchData;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.dassag.worldcupdashboard.model.Match;

public class WorldCupDataProcessor implements ItemProcessor<WorldCupData, Match> {

    @Override
    public Match process(final WorldCupData inputData) throws Exception {
        Match match = new Match();
        match.setId(Long.valueOf(inputData.getId()));
        match.setDate(LocalDate.parse(inputData.getDate()));
        match.setYear(Long.valueOf(LocalDate.parse(inputData.getDate()).getYear()));
        match.setGround(inputData.getGround());
        match.setPlayerOfTheMatch(inputData.getPlayerOfTheMatch());
        match.setResult(inputData.getResult());
        match.setTeam1(inputData.getTeam1());
        match.setTeam2(inputData.getTeam2());
        match.setStage(inputData.getStage());
        String winnerOfTheMatch = inputData.getResult().split("won by")[0];
        match.setWinner(winnerOfTheMatch.trim());
        return match;
    }

}
