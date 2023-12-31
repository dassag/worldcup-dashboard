package com.dassag.worldcupdashboard.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dassag.worldcupdashboard.model.Winner;
import com.dassag.worldcupdashboard.repository.WinnerRepository;

@RestController
@CrossOrigin
public class WinnerController {

    @Autowired
    private WinnerRepository winnerRepository;

    @GetMapping("/winner")
    public List<Winner> getAllWinners() {
        List<Winner> winnerList = (List) winnerRepository.findAll();
        if (winnerList.size() > 0) {
            Collections.reverse(winnerList);
        }
        return winnerList;
    }

    @GetMapping("/winner/{id}")
    public Winner getWinnerById(@PathVariable Long id) {
        return winnerRepository.findById(id).orElseGet(Winner::new);

    }

    @GetMapping("/winner/country/{winner}")
    public List<Long> getYearsWon(@PathVariable String winner) {
        return winnerRepository.getIdByWinnerIgnoreCase(winner).stream().map(Winner::getId)
                .collect(Collectors.toList());
    }

}
