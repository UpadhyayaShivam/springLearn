package com.example.users.projectUsers.batch;

import com.example.users.projectUsers.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CustomerItemProcessor implements ItemProcessor<Customer,Customer> {
//    private static final Logger log = LoggerFactory.getLogger(CustomerItemProcessor .class);
    @Override
    public Customer process(Customer customer) {
        System.out.println("in processor customer");

        final String customer_Name = customer.getCustomer_Name().toUpperCase();
        final Long customer_Id = customer.getCustomer_Id();

        final Customer transformedPerson = new Customer(customer_Id,customer_Name);
        System.out.println(transformedPerson);
//        log.info("Converting (" + customer + ") into (" + transformedPerson + ")");
//        System.out.flush();
        return transformedPerson;
    }
}
