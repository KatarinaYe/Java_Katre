package ee.bcs.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeControllerA {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //http://localhost:8080/employee/createEmployee2?firstName=Kuus&lastName=Kuusikut
    @GetMapping("api/employee/createEmployee2")
    public String createEmployee(String firstName, String lastName) {
        String sql = "insert into employee (first_name, last_name) VALUES (:m1, :m2)";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on loodud";

    }

    //http://localhost:8080/employee/deleteEmployee2?id=3
    @GetMapping("employee/deleteEmployee2")
    public String deleteEmployee(int id) {
        String sql = "delete from employee where id=:i ";
        Map paramMap = new HashMap();
        paramMap.put("i", id);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja on kustutatud";

    }

    //http://localhost:8080/employee/allEmployee2
    @GetMapping("employee/allEmployee2")
    public List allEmployee(String firstName, String lastName) {
        String sql = "SELECT * from employee";
        Map paramMap = new HashMap();
        paramMap.put("m1", firstName);
        paramMap.put("m2", lastName);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(AccountDto2.class));
    }

}
