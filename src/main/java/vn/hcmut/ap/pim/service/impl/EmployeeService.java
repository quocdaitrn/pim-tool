package vn.hcmut.ap.pim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hcmut.ap.pim.persistence.model.Employee;
import vn.hcmut.ap.pim.persistence.repository.IEmployeeRepository;
import vn.hcmut.ap.pim.service.IEmployeeService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findByCode(String code) {
        return employeeRepository.findByCode(code).get();
    }

    @Override
    public List<String> queryInfoEmployee(String query) {

        List<Employee> employees = employeeRepository.queryByCodeOrFirstName(query);

        List<String> sEmployees = new ArrayList<>();
        for (Employee e : employees) {
            StringBuilder s = new StringBuilder();
            s.append(e.getCode()).append(":").append(e.getFirstName()).append(" ").append(e.getLastName());
            sEmployees.add(s.toString());
        }

        return sEmployees;
    }
}
