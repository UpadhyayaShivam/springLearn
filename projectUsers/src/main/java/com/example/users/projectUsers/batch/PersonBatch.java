//package com.example.users.projectUsers.batch;
//
//import com.example.users.projectUsers.model.Person;
//import com.example.users.projectUsers.repository.PersonRepository;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.WritableResource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//public class PersonBatch {
//
//    @Value("${file.input}")
//    private String fileInput;
//
//    @Autowired
//    private JobRepository jobRepository;
//    //    @Autowired
////    private JobBuilder jobBuilder;
////    @Autowired
////    private StepBuilder stepBuilder;
//    @Autowired
//    private PersonRepository personRepository;
//    //    @Autowired
//    private Person person;
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Bean
//    public Person person() {
//        return new Person();
//    }
//
//
//    // creating job csv to csv data logic
//    @Bean
//    public Job personJobforCSV() throws Exception {
//        System.out.println("in csv job");
//        return new JobBuilder("personJobforCSV", jobRepository).start(personStepForCSV(jobRepository, person, transactionManager)).build();
//    }
//
//    @Bean
//    public Step personStepForCSV(JobRepository jobRepository, Person person, PlatformTransactionManager transactionManager) throws Exception {
//        System.out.println("in csv step");
//        return new StepBuilder("personStepForCSV", jobRepository)
//                .<Person, Person>chunk(5, transactionManager)
//                .reader(personFlatFileItemReaderViaCsv())
//                .processor(itemProcessor())
//                .writer(writerForPersonAsCSV(outputResource))
//                .build();
//    }
//
//    //    @Bean
////    public FlatFileItemReader<Person> personFlatFileItemReaderViaCsv(@Value("${inputFile}") Resource inputFile){
////        FlatFileItemReader<Person>flatFileItemReader  = new FlatFileItemReader<>();
////        flatFileItemReader.setName("personReader");
////        flatFileItemReader.setResource(inputFile);
////        flatFileItemReader.setLineMapper(LineMap());
////        return flatFileItemReader;
////
////    }
//    @Bean
//    public FlatFileItemReader<Person> personFlatFileItemReaderViaCsv() {
//        System.out.println("in reader for csv");
//        FlatFileItemReader<Person> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setName("personReader");
//        flatFileItemReader.setResource(new ClassPathResource(fileInput));
//        flatFileItemReader.setLineMapper(LineMap());
//        System.out.println("reader completed");
//        return flatFileItemReader;
//    }
//
//    @Bean
//    public LineMapper<Person> LineMap() {
//        System.out.println("in line mapper for csv");
//        DefaultLineMapper<Person> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setNames("person_Id", "person_Name", "person_Email");
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//        fieldSetMapper.setTargetType(Person.class);
//        System.out.println("line mapper completed");
//        return defaultLineMapper;
//
//    }
//
//
//    @Bean
//    public ItemProcessor<Person, Person> itemProcessor() {
//        System.out.println("in item processor");
//        return new PersonItemProcessor();
//    }
//
////    @Bean
////    public ItemWriter<Person> writer() {
////        return personRepository::saveAll;
////    }
//
////    @Bean
////    public JdbcBatchItemWriter<Person> writer(){
////        return new JdbcBatchItemWriter<>().setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
////    }
//
//    Resource outputResource = new FileSystemResource("resources/personoutput.csv");
//
//    @Bean
//    public FlatFileItemWriter<Person> writerForPersonAsCSV(Resource outputResource) throws Exception {
//        return new FlatFileItemWriterBuilder<Person>().name("personWriterForcsvOutput")
//                .resource((WritableResource) outputResource)
//                .delimited()
//                .delimiter(",")
//                .names(new String[]{"person_Id", "person_Name", "person_Email"})
//                .build();
//    }
//
//}
//    // job for csv to db
////
////    @Bean
////    public Job jobForCSVtoDB () throws Exception{
////        return  new JobBuilder("jobForCSVtoDB",jobRepository).start(stepForCSVtoDB(jobRepository,person,transactionManager)).build();
////    }
////
////    @Bean
////    public  Step stepForCSVtoDB (JobRepository jobRepository , Person person, PlatformTransactionManager transactionManager)
////    throws Exception{
////        return new StepBuilder("steoForCSVtoDB",jobRepository).<Person,Person>chunk(10,transactionManager)
////                .reader(personFlatFileItemReaderViaCsvToDB())
////                .processor(itemProcessor())
////                .writer()
////                .build();
////    }
////
////    @Bean
////    public FlatFileItemReader<Person> personFlatFileItemReaderViaCsvToDB(){
////        System.out.println("in reader for csv");
////        FlatFileItemReader<Person>flatFileItemReader  = new FlatFileItemReader<>();
////        flatFileItemReader.setName("personReaderForCSVtoDB");
////        flatFileItemReader.setResource( new ClassPathResource(fileInput));
////        flatFileItemReader.setLineMapper(LineMap2());
////        System.out.println("reader completed");
////        return flatFileItemReader;
////    }
////
////    @Bean
////    public LineMapper<Person> LineMap2(){
////        System.out.println("in line mapper for csv");
////        DefaultLineMapper<Person>defaultLineMapper = new DefaultLineMapper<>();
////        DelimitedLineTokenizer lineTokenizer =new DelimitedLineTokenizer();
////        lineTokenizer.setDelimiter(",");
////        lineTokenizer.setNames("person_Id", "person_Name", "person_Email");
////        defaultLineMapper.setLineTokenizer(lineTokenizer);
////        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
////        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
////        fieldSetMapper.setTargetType(Person.class);
////        System.out.println("line mapper completed");
////        return defaultLineMapper;
////
////    }
////
////
////
////}
