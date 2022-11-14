package ee.bcs.java.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ee.bcs.java.service.BankService;

@RestController
public class BankControllerP {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;

    // http://localhost:8080/bank/createAccountP?accountNumber=EE253
    @GetMapping("bank/createAccountP")
    public String createAccount(String accountNumber){
        return bankService.createAccount(accountNumber);
    }

    // http://localhost:8080/bank/getAccountBalanceP?accountNumber=EE123
    @GetMapping("bank/getAccountBalanceP")
    public Integer getAccountBalance(String accountNumber){
        return bankService.getAccountBalance(accountNumber);
    }



    // http://localhost:8080/bank/withdrawMoneyP?accountNumber=EE123&amount=10
    @GetMapping("bank/withdrawMoneyP")
    public String withdrawMoney(String accountNumber, Integer amount){
        return bankService.withdrawMoney(accountNumber, amount);
    }


    //http://localhost:8080/bank/transferMoneyP?fromAccount=EE147&amount=1&toAccount=EE456
    @GetMapping("bank/transferMoneyP")
    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        return bankService.transferMoney(fromAccount, toAccount, amount);
    }
}
