package fr.estia.mbds.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.toDTO(customerRepository.findById(id).orElse(null));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapper.toDTOs(customerRepository.findAll());
    }
}
