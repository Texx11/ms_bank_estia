package fr.estia.mbds.account;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        return AccountDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .dateCreated(account.getDateCreated())
                .currencyType(account.getCurrencyType())
                .customer(account.getCustomer()) // Transient, si défini
                .customerId(account.getCustomerId())
                .build();
    }

    public Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        return Account.builder()
                .id(accountDTO.getId())
                .balance(accountDTO.getBalance())
                .dateCreated(accountDTO.getDateCreated())
                .currencyType(accountDTO.getCurrencyType())
                .customer(accountDTO.getCustomer()) // Transient, si défini
                .customerId(accountDTO.getCustomerId())
                .build();
    }

    public List<AccountDTO> toDTOs(List<Account> accounts) {
        if (accounts == null || accounts.isEmpty()) {
            return new ArrayList<>(); // Retourne une liste vide si null ou vide
        }
        return accounts.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Account> toEntities(List<AccountDTO> accountDTOs) {
        if (accountDTOs == null || accountDTOs.isEmpty()) {
            return new ArrayList<>(); // Retourne une liste vide si null ou vide
        }
        return accountDTOs.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
