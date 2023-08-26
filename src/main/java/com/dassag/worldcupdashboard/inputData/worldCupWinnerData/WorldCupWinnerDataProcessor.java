package com.dassag.worldcupdashboard.inputData.worldCupWinnerData;

import org.springframework.batch.item.ItemProcessor;

import com.dassag.worldcupdashboard.inputData.WorldCupMatchData.WorldCupData;
import com.dassag.worldcupdashboard.model.Match;
import com.dassag.worldcupdashboard.model.Winner;

public class WorldCupWinnerDataProcessor implements ItemProcessor<WorldCupWinnerData, Winner> {

    @Override
    public Winner process(WorldCupWinnerData winnerData) throws Exception {
        Winner winner = new Winner();
        winner.setId(winnerData.getId());
        winner.setWinner(winnerData.getWinner());
        winner.setName(winnerData.getName());

        return winner;
    }

}
