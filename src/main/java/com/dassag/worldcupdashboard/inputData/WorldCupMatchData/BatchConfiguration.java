package com.dassag.worldcupdashboard.inputData.WorldCupMatchData;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.dassag.worldcupdashboard.inputData.WorldCupMatchData.WorldCupDataProcessor;
import com.dassag.worldcupdashboard.model.Match;

@Configuration
public class BatchConfiguration {

    private final String[] FIELD_NAMES = new String[] {
            "id", "date", "team1", "team2", "ground", "result", "player_of_the_match", "stage"
    };

    @Bean
    public FlatFileItemReader<WorldCupData> reader() {
        return new FlatFileItemReaderBuilder<WorldCupData>()
                .name("WorldCupDataItemReader")
                .resource(new ClassPathResource("Prudential_world_cup_1983.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<WorldCupData>() {
                    {
                        setTargetType(WorldCupData.class);
                    }
                })
                .build();
    }

    @Bean
    public WorldCupDataProcessor processor() {
        return new WorldCupDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "INSERT INTO match (id, date, team1, team2, ground, result, player_of_the_match, stage, year, winner)"
                                + " VALUES (:id, :date, :team1, :team2, :ground, :result, :playerOfTheMatch, :stage, :year, :winner)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Match> writer) {
        return new StepBuilder("step1", jobRepository)
                .<WorldCupData, Match>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
