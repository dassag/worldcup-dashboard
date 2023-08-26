package com.dassag.worldcupdashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dassag.worldcupdashboard.model.Winner;
import com.dassag.worldcupdashboard.repository.WinnerRepository;

@RestController
public class WinnerController {

    @Autowired
    private WinnerRepository winnerRepository;

    @GetMapping("/winner")
    public List<Winner> getAllWinners() {
        return (List) winnerRepository.findAll();
    }

}
