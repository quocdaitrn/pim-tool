package vn.hcmut.ap.pim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hcmut.ap.pim.dto.EmployeeDto;
import vn.hcmut.ap.pim.persistence.model.Employee;
import vn.hcmut.ap.pim.service.IEmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/employees", params = { "query" })
    public List<String> queryEmployeeByCodeOrFirstName(@RequestParam("query") String query) {
        return employeeService.queryInfoEmployee(query);
    }

    @PostMapping(value = "/employees")
    public void addEmployee(@RequestBody EmployeeDto emp) {
        Employee e = new Employee();
        e.setCode(emp.getCode());
        e.setFirstName(emp.getFirstName());
        e.setLastName(emp.getLastName());
        e.setBirthDate(emp.getBirthDate());

        employeeService.addEmployee(e);
    }
}
