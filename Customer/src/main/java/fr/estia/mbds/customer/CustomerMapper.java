package fr.estia.mbds.customer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public Customer toEntities(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        return Customer.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .build();
    }

    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    public List<CustomerDTO> toDTOs(List<Customer> customers){
        if (customers == null || customers.isEmpty()) {
            return new ArrayList<>(); // Retourne une liste vide si l'entrée est null ou vide
        }

        return customers.stream()
                .map(this::toDTO) // Applique la méthode toDTO pour chaque élément
                .collect(Collectors.toList()); // Collecte le résultat dans une liste
    }
}
