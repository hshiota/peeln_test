package com.ngc.peeln.es;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public String test() {
        return "lambdaでサービスクラスを呼び出せるかテスト";
    }
}
