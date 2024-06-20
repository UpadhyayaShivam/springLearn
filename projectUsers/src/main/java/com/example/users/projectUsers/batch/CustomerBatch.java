//package com.example.users.projectUsers.batch;
//
//import com.example.users.projectUsers.model.Customer;
//
//import com.example.users.projectUsers.repository.CustomerRepository;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
//import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.WritableResource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class CustomerBatch {
//
//    @Value("${file.input}")
//    private String fileInput;
//
////    @Value("${file.output}")
////    private String output;
//
//    WritableResource outputResource = new FileSystemResource("resources/personoutput.csv");
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Customer customer;
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Bean
//    public Customer customer() {
//        return new Customer();
//    }
//
//
//    // creating job csv to csv data logic
//    @Bean
//    public Job customerJobforCSV() throws Exception {
////        System.out.println("in csv job of customer");
//        return new JobBuilder("personJobforCSVcustomer", jobRepository).incrementer(new RunIdIncrementer())
//                .start(customerStepForCSV(jobRepository, customer, transactionManager)).build();
//    }
//
//    @Bean
//    public Step customerStepForCSV(JobRepository jobRepository, Customer customer, PlatformTransactionManager transactionManager) throws Exception {
//        System.out.println("in csv step customer");
//        return new StepBuilder("personStepForCSVcustomer", jobRepository)
//                .<Customer, Customer>chunk(1, transactionManager)
//                .reader(customerFlatFileItemReader())
//                .processor(itemProcessor())
//                .writer(dbWriter(dataSource))
//                .build();
//    }
//
//
//    @Bean
//    public FlatFileItemReader<Customer> customerFlatFileItemReader() {
//        System.out.println("in reader for csv customer");
//        FlatFileItemReader<Customer> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setName("customerReader");
//        flatFileItemReader.setResource(new ClassPathResource(fileInput));
//        flatFileItemReader.setLineMapper(LineMap());
//        System.out.println("reader completed");
//        return flatFileItemReader;
//    }
//
//    @Bean
//
//    public LineMapper<Customer> LineMap() {
//        System.out.println("in line mapper for csv");
//        DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setNames("customer_Id", "customer_Name");
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//        fieldSetMapper.setTargetType(Customer.class);
//        System.out.println("line mapper completed");
//        return defaultLineMapper;
//
//    }
//
//
//    @Bean
//    public ItemProcessor<Customer, Customer> itemProcessor() {
//        System.out.println("in item processor");
//        return new CustomerItemProcessor();
//    }
//
////    @Bean
////    public FlatFileItemWriter<Customer> writerForPersonAsCSV(WritableResource outputResource) throws Exception {
////        System.out.println("in the writer for customer");
////        return new FlatFileItemWriterBuilder<Customer>().name("personWriterForcsvOutput")
////                .resource(outputResource)
////                .delimited()
////                .delimiter(",")
////                .names(new String[]{"customer_Id", "customer_Name"})
////                .shouldDeleteIfExists(true)
////                .build();
////    }
//
////    @Bean
////    public FlatFileItemWriter<Customer> itemWriter(WritableResource outputResource) throws Exception {
////        System.out.println("in item writer ...");
////        BeanWrapperFieldExtractor<Customer> fieldExtractor = new BeanWrapperFieldExtractor<>();
////        fieldExtractor.setNames(new String[] {"customer_Id", "customer_Name"});
////        fieldExtractor.afterPropertiesSet();
////
////        DelimitedLineAggregator<Customer> lineAggregator = new DelimitedLineAggregator<>();
////        lineAggregator.setDelimiter(",");
////        lineAggregator.setFieldExtractor(fieldExtractor);
////
////        return new FlatFileItemWriterBuilder<Customer>()
////                .name("customerWriterCSV")
////                .resource(outputResource)
////                .lineAggregator(lineAggregator)
////                .build();
////    }
//
//
//    // for csv to db
//    @Bean
//    public JdbcBatchItemWriter<Customer> dbWriter(DataSource dataSource){
//        System.out.println("in db writer.....");
//        return new JdbcBatchItemWriterBuilder<Customer>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("insert into customer (customer_Id, customer_Name) values (:customer_Id,:customer_Name)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//
//
//}
