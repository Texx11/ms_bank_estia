package fr.estia.mbds.account;

import java.util.List;

public interface AccountService {
    public List<AccountDTO> getAllAccounts();
    public AccountDTO getAccountById(String id);
}
