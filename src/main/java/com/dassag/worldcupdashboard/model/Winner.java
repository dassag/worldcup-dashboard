package com.dassag.worldcupdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Winner {

    @Id
    private Long id;
    private String name;
    private String winner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String worldCupName) {
        this.name = worldCupName;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winningCountry) {
        this.winner = winningCountry;
    }
}
