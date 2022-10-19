package ee.bcs.java.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String f1(String accountNumber) {
        String sql = "INSERT INTO account (account_number, balance) VALUES (:accountNumber, :amount)";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("amount", 0);
        jdbcTemplate.update(sql, paramMap);
        return sql;
    }

    public Integer f2(String accountNumber) {
        String sql = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return balance;
    }

    public Integer f3(String accountNumber) {
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        return jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
    }

    public Integer f4(String accountNumber) {
        String sql2 = "SELECT balance FROM account WHERE account_number = :accountNumber";
        Map paramMap2 = new HashMap();
        paramMap2.put("accountNumber", accountNumber);
        return jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);
    }

    public void f5(String accountNumber, Integer newBalance) {
        String sql = "UPDATE account SET balance = :balance WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }
}
