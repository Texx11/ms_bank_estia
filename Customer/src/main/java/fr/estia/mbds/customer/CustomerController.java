package fr.estia.mbds.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElse(null);
    }

    @GetMapping("customers/")
    public Customer getCustomers(){
        return null;
    }
}
