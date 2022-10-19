package ee.bcs.java.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ee.bcs.java.service.BankService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;

    // http://localhost:8080/bank/createAccount?accountNumber=EE253
    @GetMapping("bank/createAccount")
    public String createAccount(String accountNumber){
        return bankService.createAccount(accountNumber);
    }

    // http://localhost:8080/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber){
        return bankService.getAccountBalance(accountNumber);
    }

    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/depositMoney")
    public String depositMoney(String accountNumber, Integer amount){
        return bankService.depositMoney(accountNumber, amount);
    }

    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=10
    @GetMapping("bank/withdrawMoney")
    public String withdrawMoney(String accountNumber, Integer amount){
        return bankService.withdrawMoney(accountNumber, amount);
    }


    //http://localhost:8080/bank/transferMoney?fromAccount=EE147&amount=1&toAccount=EE456
    @GetMapping("bank/transferMoney")
    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        return bankService.transferMoney(fromAccount, toAccount, amount);
    }
}
