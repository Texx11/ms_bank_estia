package fr.estia.mbds.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private CustomerClient customerClient;
    private AccountService accountService;

    public AccountController(AccountService accountService, CustomerClient customerClient){
        this.accountService = accountService;
        this.customerClient = customerClient;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts(){
        List<AccountDTO> accountList = accountService.getAllAccounts();
        accountList.forEach(account -> {
            account.setCustomer(customerClient.getCustomer(account.getCustomerId()));
        });

        return accountList;
    }

    @GetMapping("/account/{id}")
    public AccountDTO getAccount(@PathVariable String id){
        AccountDTO accountInstance =  accountService.getAccountById(id);
        if (accountInstance == null){
            return null;
        }
        Customer customer =  customerClient.getCustomer(accountInstance.getCustomerId());
        accountInstance.setCustomer(customer);

        return accountInstance;
    }
}
