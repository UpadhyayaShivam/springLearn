//package com.example.users.projectUsers.batch;
//
//import com.example.users.projectUsers.model.Users;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//
//public class userItemProcessor implements ItemProcessor<Users,Users> {
//    private static final Logger log = LoggerFactory.getLogger(userItemProcessor.class);
//
////    @Override
//    public Users process( Users user) {
//        final String first_Name = user.getFirst_name().toUpperCase();
//        final String last_Name = user.getLast_name().toUpperCase();
//
//        final Users transformedUser = new Users(first_Name, last_Name);
//
//        log.info("Converting (" + user + ") into (" + transformedUser + ")");
//
//        return transformedUser;
//    }
//}
