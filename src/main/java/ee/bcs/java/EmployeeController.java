package ee.bcs.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //http://localhost:8080/employee/createEmployee
    @GetMapping("employee/createEmployee")
    public String createEmployee(String firstName, String lastName) {
        String sql = "insert into employee (first_name, last_name) VALUES (:m1, :m2)";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on loodud";

    }

    //http://localhost:8080/employee/deleteEmployee
    @GetMapping("employee/deleteEmployee")
    public String deleteEmployee(int id) {
        String sql = "delete from employee where id=:i ";
        Map paramMap = new HashMap();
        paramMap.put("i", id);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on kustutatud";

    }

}
