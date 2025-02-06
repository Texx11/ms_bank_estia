package fr.estia.mbds.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers(){
        return customerService.getAllCustomers();
    }
}
