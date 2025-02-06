package fr.estia.mbds.customer;

import java.util.List;

public interface CustomerService {
    public CustomerDTO getCustomerById(Long id);
    public List<CustomerDTO> getAllCustomers();
}
