//package com.example.users.projectUsers.batch;
//
//import com.example.users.projectUsers.model.Users;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.JobRegistry;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//
//public class userBatch {
//
//    @Autowired
//    private DataSource dataSource;
//    @Bean
//    public FlatFileItemReader<Users> reader () {
//        return new FlatFileItemReaderBuilder<Users>()
//                .name("itemReader")
//                .resource(new ClassPathResource("users.csv"))
//                .delimited().names(new String[]{"user_id","first_name", "last_name"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
//                    setTargetType(Users.class);
//                }}).lineMapper(new DefaultLineMapper<Users>() {{
//                    setLineTokenizer(new DelimitedLineTokenizer() {{
//                        setNames("user_id", "first_name", "last_name");
//                        // Handle extra tokens (optional)
//                        setStrict(false); // Allow extra tokens (comment out if needed)
//                    }});
//                    setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
//                        setTargetType(Users.class);
//                    }});
//                }})
//                .build();
//    }
//
////    @Bean
////    public ItemProcessor<Users, Users> processor(){
////        return User -> {
////            User.setFirst_name(User.getFirst_name().toUpperCase());
////            User.setLast_name(User.getLast_name().toUpperCase());
////            return User;
////        };
////    }
////@Bean
////public ItemProcessor<Users, Users> processor(){
////    return User -> {
////        User.setFirst_name(User.getFirst_name().toUpperCase());
////        User.setLast_name(User.getLast_name().toUpperCase());
////        return User;
////    };
////}
//
//@Bean
//public ItemProcessor<Users,Users> processor(){
//    return new userItemProcessor();
//}
//
//    @Bean
//    public JdbcBatchItemWriter<Users> writer(DataSource dataSource){
//        return new JdbcBatchItemWriterBuilder<Users>()
//                .sql("INSERT into users  (user_id,first_name, last_name) VALUES (:user_id,:first_name, :last_name)")
//                .dataSource(dataSource)
//                .beanMapped().build();
//
//    }
//
////    @Bean
////    public Step step1(JobRepository jobRepository,
////                      PlatformTransactionManager platformTransactionManager ,
////                      JdbcBatchItemWriter<Users> writer ){
////        return new StepBuilder("step1", jobRepository)
////                .chunk(3, platformTransactionManager)
////                .reader(reader())
////                .processor(processor())
////                .writer(writer)
////                .build();
////
////    }
//
//    @Bean
//    public Step step1(JobRepository jobRepository,
//                      PlatformTransactionManager platformTransactionManager ,
//                      JdbcBatchItemWriter<Users> writer ){
//        return new StepBuilder("step1", jobRepository)
//                .<Users,Users>chunk(4, platformTransactionManager)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//
//    }
//
//    @Bean
//    public Job job (JobRepository jobRepository, Step step1){
//        return new JobBuilder("job",jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(step1)
//                .build();
//
//    }
//
//
//}
