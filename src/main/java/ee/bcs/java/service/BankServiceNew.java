package ee.bcs.java.service;


import ee.bcs.java.Account.AccountRepositoryNew;
import ee.bcs.java.tasks.AccountDto;
import ee.bcs.java.tasks.BankControllerNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankServiceNew {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepositoryNew accountRepository;

    public String createAccount(String accountNumber, int clientID) {
        return accountRepository.f1(accountNumber, clientID);
    }

    public Integer getAccountBalance(String accountNumber) {
        return accountRepository.f2(accountNumber);
    }

    public String withdrawMoney(String accountNumber, Integer amount) {
        if (amount <= 0) {
            return "Sisestatud summa peab olema suurem kui null";
        }
        Integer oldBalance = accountRepository.f4(accountNumber);
        if (oldBalance < amount) {
            return "Kontol pole piisavalt raha";
        }
        Integer newBalance = oldBalance - amount;

        accountRepository.f5(accountNumber, newBalance);
        return "Raha välja antud";
    }

    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        if (amount <= 0) {
            return "Sisestatud summa peab olema suurem kui null";
        }
        String sql4 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap4 = new HashMap();
        paramMap4.put("accountNumber", fromAccount);
        Integer fromAccountOldBalance = jdbcTemplate.queryForObject(sql4, paramMap4, Integer.class);

        Integer fromAccountNewBalance = fromAccountOldBalance - amount;

        String sql3 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap3 = new HashMap();
        paramMap3.put("accountNumber", fromAccount);
        paramMap3.put("balance", fromAccountNewBalance);
        jdbcTemplate.update(sql3, paramMap3);
        if (fromAccountOldBalance < amount) {
            return "Kontol pole piisavalt raha";
        }

        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", toAccount);
        Integer toAccountOldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        Integer toAccountNewBalance = toAccountOldBalance + amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", toAccount);
        paramMap.put("balance", toAccountNewBalance);
        jdbcTemplate.update(sql, paramMap);

        return ("Kontolt:  " + fromAccount + ("  kanti summa:  ") + amount + "  euro(t) üle kontole:  " + toAccount);
    }

    public void setAccountRepository(AccountRepositoryNew accountRepository) {
        this.accountRepository = accountRepository;
    }


    public List<AccountDto> getAllAccount() {
        return accountRepository.findAll();


    }
}
