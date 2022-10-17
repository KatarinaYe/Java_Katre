package ee.bcs.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
public class BankControllerU {
    Map<String, Integer> accounts = new HashMap<>();
    // accounts.put("EE123456", 123.0);
    // accounts.get("EE123456");

    //http://localhost:8080/bank/test
    @GetMapping("bank/test")
    public String bankTest(){
        return "test";
    }
    // http://lockalhost:8080/bank/test?a=midagi&b=midagimuud
    @GetMapping("bank/test2")
    public String bankTest2(String a, String b){
        return "test";
    }
    //http://lockalhost:8080/bank/createAccount?accountNr=EE12345
    @GetMapping("bank/createAccountU")
    public String createAccount(String accountNr){
        accounts.put(accountNr, 0);
        return "Account " + accountNr + " created";
    }
    //http://lockalhost:8080/bank/balance
    @GetMapping("bank/balanceU")
    public String getBalance (String accountNr){
        int balance = accounts.get(accountNr);
        return "Account balance is " + balance;
    }
    //http://lockalhost:8080/bank/depositU
    @GetMapping("bank/depositU")
    public String depositMoney (String accountNr, int amount){
        if(amount<= 0){
            return "Sum must be higher than zero";
        }
        int balance = accounts.get(accountNr);
        int newBalance = balance + amount;
        accounts.put(accountNr, newBalance);
        return "You deposited " + amount + "and new account balance is " + newBalance;
    }

    //http://lockalhost:8080/bank/withdrawMoneyU
    @GetMapping("bank/withdrawMoneyU")
    public String withdrawMoney (String accountNr, int amount){
        if (amount <= 0){
            return "Sum must be higher than zero";
        }
        int balance = accounts.get(accountNr);
        int newBalance = balance - amount;
        accounts.put(accountNr, newBalance);
        return "You withdrawed " + amount + "and new account balance is " + newBalance;
    }

    //http://lockalhost:8080/bank/transferU
    @GetMapping("bank/transferU")
    public String transfer (String accountNr, int amount){
        int balance = accounts.get(accountNr);
        int newBalance = balance - amount;
        accounts.put(accountNr, newBalance);
        return "You transfer " + amount + "and new account balance is " + newBalance;
    }

}
