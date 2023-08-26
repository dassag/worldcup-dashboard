package com.dassag.worldcupdashboard.inputData.worldCupWinnerData;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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

import com.dassag.worldcupdashboard.model.Match;
import com.dassag.worldcupdashboard.model.Winner;

@Configuration
public class WinnerBatchConfiguration {

    private final String[] FIELD_NAMES = new String[] {
            "id", "name", "winner"
    };

    @Bean
    public FlatFileItemReader<WorldCupWinnerData> winnerReader() {
        return new FlatFileItemReaderBuilder<WorldCupWinnerData>()
                .name("WorldCupWinnerDataItemReader")
                .resource(new ClassPathResource("WorldCupWinnerData.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<WorldCupWinnerData>() {
                    {
                        setTargetType(WorldCupWinnerData.class);
                    }
                })
                .build();
    }

    @Bean
    public WorldCupWinnerDataProcessor winnerProcessor() {
        return new WorldCupWinnerDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Winner> winnerWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Winner>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO winner (id, name, winner)"
                        + " VALUES (:id, :name, :winner)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importWinnerDataJob(JobRepository jobRepository,
            WinnerJobCompletionNotificationListener listener, Step step0) {
        return new JobBuilder("importWinnerDataJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step0)
                .end()
                .build();
    }

    @Bean
    public Step step0(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Winner> writer) {
        return new StepBuilder("step0", jobRepository)
                .<WorldCupWinnerData, Winner>chunk(10, transactionManager)
                .reader(winnerReader())
                .processor(winnerProcessor())
                .writer(writer)
                .build();
    }

}
