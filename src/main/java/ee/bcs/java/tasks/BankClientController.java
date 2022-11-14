package ee.bcs.java.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class BankClientController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/bank_solution/createNewClient?firstName=Test&lastName=Kasutaja
    @GetMapping("bank_solution/createNewClient")
    public String createClient(String firstName, String lastName) {
        String sql = "INSERT INTO client (first_name, last_name) VALUES (:m1, :m2)";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
        return "New client ";

    }
}
