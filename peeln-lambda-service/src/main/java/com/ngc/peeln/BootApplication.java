package com.ngc.peeln;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ngc.peeln.es.Customer;
import com.ngc.peeln.es.CustomerRepository;
import com.ngc.peeln.es.ServiceService;

@SpringBootApplication
public class BootApplication implements CommandLineRunner {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ServiceService serviceService;

    /**
     * 起動時に実行されるメソッド 中身は任意
     */
    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();// TODO あとで消すこと
        saveCustomers();
        fetchAllCustomers();
        fetchIndividualCustomers();
        logger.info(serviceService.test() + "\n");
    }

    private void saveCustomers() {
        this.serviceService.save(new Customer("Alice", "Smith"));
        this.serviceService.save(new Customer("Bob", "Smith"));
    }

    private void fetchAllCustomers() {
        logger.info("\n");
        logger.info(">>>>>Customers found with findAll():");
        for (Customer customer : this.serviceService.findAll()) {
            logger.info(ToStringBuilder.reflectionToString(customer));
        }
        logger.info("\n");
    }

    private void fetchIndividualCustomers() {
        logger.info(">>>>>Customer found with findByFirstName('Alice'):");
        logger.info(ToStringBuilder.reflectionToString(this.serviceService.findByFirstName("Alice")));
        logger.info("\n");

        logger.info(">>>>>Customers found with findByLastName('Smith'):");
        for (Customer customer : this.serviceService.findByLastName("Smith")) {
            logger.info(ToStringBuilder.reflectionToString(customer));
        }
        logger.info("\n");
    }

    public static void main(String[] args) throws Exception {
        // SpringApplication.run(Application.class, "--debug").close();
        SpringApplication.run(BootApplication.class, args).close();
    }

}
