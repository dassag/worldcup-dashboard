package com.dassag.worldcupdashboard.inputData.WorldCupMatchData;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dassag.worldcupdashboard.model.Country;
import com.dassag.worldcupdashboard.model.Match;

import jakarta.persistence.EntityManager;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final EntityManager entityManager;

    @Autowired
    public JobCompletionNotificationListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            Map<String, Country> countryData = new HashMap();

            entityManager.createQuery("Select distinct m.Team1, count(*) from Match m group by m.Team1", Object[].class)
                    .getResultList()
                    .stream()
                    .map(country -> new Country((String) country[0], (Long) country[1]))
                    .forEach(country -> countryData.put(country.getCountryName(), country));

            entityManager.createQuery("Select distinct m.Team2, count(*) from Match m group by m.Team2", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(countryObj -> {
                        Country country = countryData.get((String) countryObj[0]);
                        if (country != null) {
                            country.setTotalMatchesPlayed(country.getTotalMatchesPlayed() + (Long) countryObj[1]);
                        } else {
                            countryData.put((String) countryObj[0],
                                    new Country((String) countryObj[0], (Long) countryObj[1]));
                        }

                    });

            entityManager.createQuery("select w.winner, count(*) from Winner w group by w.winner", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(countryObj -> {
                        Country country = countryData.get((String) countryObj[0]);
                        if (country != null) {
                            country.setWorldCupCount((Long) countryObj[1]);
                        }
                    });

            countryData.values().forEach(country -> entityManager.persist(country));
            countryData.values().forEach(country -> System.out.println(country));

        }
    }
}
