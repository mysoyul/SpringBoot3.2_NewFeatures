package dev.boot3.blogpost.service;

import dev.boot3.blogpost.dto.Customer;
import dev.boot3.blogpost.exception.PostNotFoundException;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customerList=new ArrayList<>();
    @Autowired
    private ObservationRegistry registry;

    @PostConstruct
    public void initCustomer() {
        customerList.add(new Customer(101,"Spring Boot","boot@aa.com","Male"));
        customerList.add(new Customer(102,"Spring Data","data@aa.com","FeMale"));
        customerList.add(new Customer(103,"Spring Cloud","cloud@aa.com","Male"));
    }

    public Customer addCustomer(Customer customer) {
        customerList.add(customer);
        //return customer;
        return Observation.createNotStarted("addCustomer", registry)
                .observe(() -> customer);
    }

    public List<Customer> getCustomers(){
        //return customerList;
        return Observation.createNotStarted("getCustomers", registry)
                .observe(() -> customerList);
    }

    public Customer getCustomer(int id) {
//        return customerList.stream().filter(customer -> customer.id() == id)
//                .findAny().orElseThrow(()->new RuntimeException("Customer Not found with id "+id));
        Customer existCustomer = customerList.stream().filter(customer -> customer.id() == id)
                .findAny().orElseThrow(() -> new PostNotFoundException(id));
        return Observation.createNotStarted("getCustomerById", registry)
                .observe(() -> existCustomer);
    }

}
