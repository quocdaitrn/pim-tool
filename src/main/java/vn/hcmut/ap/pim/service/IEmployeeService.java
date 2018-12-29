package vn.hcmut.ap.pim.service;

import vn.hcmut.ap.pim.persistence.model.Employee;

import java.util.List;

public interface IEmployeeService {
    void addEmployee(Employee employee);

    Employee findByCode(String code);

    List<String> queryInfoEmployee(String query);
}
