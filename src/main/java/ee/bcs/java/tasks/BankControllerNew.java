package ee.bcs.java.tasks;


import ee.bcs.java.service.BankServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankControllerNew {
@Autowired
    private BankServiceNew bankService;

    // http://localhost:8080/bank/createNewAccount?accountNumber=EE253&clientID=555
    @GetMapping("api/bank/createNewAccount")
    public String createAccount(String accountNumber, int clientID){
        return bankService.createAccount(accountNumber, clientID);
    }

    // http://localhost:8080/bank/getAccountBalance?accountNumber=EE123
    @GetMapping("api/bank/getAccountBalance")
    public Integer getAccountBalance(String accountNumber){
        return bankService.getAccountBalance(accountNumber);
    }


    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=10
    @GetMapping("api/bank/withdrawMoney")
    public String withdrawMoney(String accountNumber, Integer amount){
        return bankService.withdrawMoney(accountNumber, amount);
    }


    //http://localhost:8080/bank/transferMoney?fromAccount=EE147&amount=1&toAccount=EE456
    @GetMapping("api/bank/transferMoney")
    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        return bankService.transferMoney(fromAccount, toAccount, amount);
    }
    //http://localhost:8080/bank/allAccounts
    @GetMapping("api/bank/allAccounts")
    public List<AccountDto> getAllAccounts(){
        return bankService.getAllAccount();
    }


}
