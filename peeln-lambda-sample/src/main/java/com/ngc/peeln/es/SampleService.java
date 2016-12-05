package com.ngc.peeln.es;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SampleService {

    Customer save(Customer customer);
    
    void deleteAll();

    Iterable<Customer> findAll();

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    String test();
}
