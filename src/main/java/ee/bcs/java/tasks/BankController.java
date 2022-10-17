package ee.bcs.java.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/bank/createAccount?accountNumber=EE253
    @GetMapping("bank/createAccount")
    public String createAccount(String accountNumber){
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, :amount)";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("amount", 0);
        jdbcTemplate.update(sql, paramMap);
        return "Konto lisatud.";

    }

    // http://localhost:8080/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber){
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/depositMoney")
    public void depositMoney(String accountNumber, Integer amount){
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        Integer newBalance = oldBalance + amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/withdrawMoney")
    public void withdrawMoney(String accountNumber, Integer amount){
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        Integer newBalance = oldBalance - amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    //http://localhost:8080/bank/transferMoney?fromAccount=EE147&amount=1&toAccount=EE456
    @GetMapping("bank/transferMoney")
    public void transferMoney(String fromAccount, String toAccount, Integer amount){
        String sql4 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap4 = new HashMap();
        paramMap4.put("accountNumber", fromAccount);
        Integer oldBalance = jdbcTemplate.queryForObject(sql4, paramMap4, Integer.class);

        Integer newBalance = oldBalance - amount;

        String sql3 = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap3 = new HashMap();
        paramMap3.put("accountNumber", fromAccount);
        paramMap3.put("balance", newBalance);
        jdbcTemplate.update(sql3, paramMap3);

        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", toAccount);
        Integer oldBalance2 = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        Integer newBalance2 = oldBalance2 + amount;

        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", toAccount);
        paramMap.put("balance", newBalance2);
        jdbcTemplate.update(sql, paramMap);

    }

}
