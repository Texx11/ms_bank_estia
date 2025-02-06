package fr.estia.mbds.account;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Account {
    @Id
    private String id;
    private double balance;
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    @Transient
    private Customer customer;
    private Long customerId; 
}
