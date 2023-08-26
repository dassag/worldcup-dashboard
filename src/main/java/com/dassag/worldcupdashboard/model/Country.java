package com.dassag.worldcupdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String countryName;
    private Long worldCupCount;
    private Long totalMatchesPlayed;
    private Long totalWins;

    public Country() {
    }

    public Country(String countryName, Long totalMatchesPlayed) {
        this.countryName = countryName;
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public Long getWorldCupCount() {
        return worldCupCount;
    }

    public Long getTotalMatchesPlayed() {
        return totalMatchesPlayed;
    }

    public Long getTotalWins() {
        return totalWins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setWorldCupCount(Long worldCupCount) {
        this.worldCupCount = worldCupCount;
    }

    public void setTotalMatchesPlayed(Long totalMatchesPlayed) {
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return "Country [countryName=" + countryName + ", worldCupCount=" + worldCupCount + ", totalMatchesPlayed="
                + totalMatchesPlayed + "]";
    }

}
