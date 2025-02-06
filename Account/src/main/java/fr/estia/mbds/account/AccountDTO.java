package fr.estia.mbds.account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String id;
    private double balance;
    private LocalDate dateCreated;
    private CurrencyType currencyType;
    private Customer customer;
    private Long customerId;
}
