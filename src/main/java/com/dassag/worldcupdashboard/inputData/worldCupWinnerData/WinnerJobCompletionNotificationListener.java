package com.dassag.worldcupdashboard.inputData.worldCupWinnerData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dassag.worldcupdashboard.inputData.WorldCupMatchData.JobCompletionNotificationListener;

import jakarta.persistence.EntityManager;

@Component
public class WinnerJobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final JdbcTemplate entityManager;

    @Autowired
    public WinnerJobCompletionNotificationListener(JdbcTemplate entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            entityManager
                    .query("select id, name, winner from winner",
                            (rs, row) -> rs.getString(2) + " " + rs.getString(1) + " won by " + rs.getString(3))
                    .forEach(str -> System.out.println(str));
        }
    }
}
