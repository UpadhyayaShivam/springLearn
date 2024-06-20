package com.example.users.projectUsers.batch;


import com.example.users.projectUsers.model.Customer;
import com.example.users.projectUsers.model.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration

public class SchedulingBatchPart {

    @Value("${file.input}")
    private String fileInput;
//    Resource inputFile1 = new ClassPathResource("resources/person.csv");
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private Person person;

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Job jobForScheduling1 ()throws Exception{
        return new JobBuilder("JobScheduling1", jobRepository).incrementer(new RunIdIncrementer())
                .start(StepScheduling1(jobRepository,person , transactionManager)).build();

    }

    @Bean
    public Job jobForScheduling2 () throws Exception {
        return new JobBuilder("JobScheduling2", jobRepository).incrementer(new RunIdIncrementer())
                .start(StepScheduling2(jobRepository, person, transactionManager)).build();
    }

    @Bean
    public Step StepScheduling1(JobRepository jobRepository,Person person, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("StepScheduling1", jobRepository)
                .<Person, Person>chunk(1, transactionManager)
                .reader(scheduling1Reader())
                .processor(processor1())
                .writer(writerDB1(dataSource))
                .build();
    }

    public Step StepScheduling2(JobRepository jobRepository, Person person, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("StepScheduling2", jobRepository)
                .<Person, Person>chunk(1, transactionManager)
                .reader(scheduling1Reader())
                .processor(processor2())
                .writer(writerDB1(dataSource))
                .build();
    }

    @Bean
    public FlatFileItemReader<Person> scheduling1Reader(){
        FlatFileItemReader<Person> flatFileItemReader1 = new FlatFileItemReader<>();
        flatFileItemReader1.setName("schedulingReader");
        flatFileItemReader1.setResource(new ClassPathResource(fileInput));
        flatFileItemReader1.setLineMapper(lineMapper1());
        return  flatFileItemReader1;
    }

    @Bean
    public LineMapper<Person> lineMapper1(){
        DefaultLineMapper <Person> defaultLineMapper1 = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer1 = new DelimitedLineTokenizer();
        BeanWrapperFieldSetMapper<Person> fieldSetMapper1 = new BeanWrapperFieldSetMapper<>();
        lineTokenizer1.setDelimiter(",");
        lineTokenizer1.setNames("person_Name","person_Email");
        defaultLineMapper1.setLineTokenizer(lineTokenizer1);
        defaultLineMapper1.setFieldSetMapper(fieldSetMapper1);
        fieldSetMapper1.setTargetType(Person.class);
        return defaultLineMapper1;
    }

    @Bean
    public ItemProcessor<Person,Person> processor1(){
        return new SchedulingItemProcessor1();
    }
    @Bean
    public ItemProcessor<Person,Person> processor2(){
        return new SchedulingItemProcessor2();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writerDB1(DataSource dataSource){
       return new JdbcBatchItemWriterBuilder<Person>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
               .sql("insert into person (person_Id,person_Name,person_Email) values (:person_Id,:person_Name,:person_Email)")
               .dataSource(dataSource)
               .build();
    }


}
