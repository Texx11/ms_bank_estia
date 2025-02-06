package fr.estia.mbds.account;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountMapper.toDTOs(accountRepository.findAll());
    }

    @Override
    public AccountDTO getAccountById(String id) {
        return accountMapper.toDTO(accountRepository.findById(id).orElse(null));
    }
}
