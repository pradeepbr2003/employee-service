package org.example.service;

import org.example.client.Company;
import org.example.client.CompanyService;
import org.example.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private List<Employee> employeeBean;

    @Autowired
    private CompanyService companyService;

    public String addEmployee(Employee employee) {
        Optional<Employee> optEmployee = employeeBean.stream().filter(e -> (e.getEmpId() == employee.getEmpId())).findAny();
        if (optEmployee.isPresent()) {
            return String.format("Employee with %d and %s already exists", employee.getEmpId(), employee.getEmpName());
        }
        employeeBean.add(employee);
        return String.format("Employee with %d and %s added", employee.getEmpId(), employee.getEmpName());
    }

    public Map<String, Object> getAllEmployees() {
        List<Company> companyList = companyService.getAllCompanies();
        Map map = Map.of("employees", employeeBean, "companies", companyList);
        return map;
    }

    public Map<String, Object> getEmployeeById(Integer id) {
        Optional<Employee> optEmployee = employeeBean.stream().filter(e -> e.getEmpId() == id).findAny();
        if (optEmployee.isPresent()) {
            return Map.of("employee", optEmployee.get(), "company-name", companyService.getCompanyName(id));
        }
        return Map.of(id.toString(), "This Employee does not exists");
    }

    public String deleteEmployeeById(Integer id) {
        boolean employeeDeleted = employeeBean.removeIf(e -> (e.getEmpId() == id));
        if (employeeDeleted) {
            return String.format("Employee with %d is successfully deleted", id);
        }
        return String.format("No Such Employee with %d exists", id);
    }

    public String updateEmployee(Employee employee) {
        Optional<Employee> optEmployee = employeeBean.stream().filter(e -> (e.getEmpId() == employee.getEmpId())).findAny();
        if (optEmployee.isPresent()) {
            Employee updateEmployee = optEmployee.get();
            if (employee.getEmpName() != null) updateEmployee.setEmpName(employee.getEmpName());
            if (employee.getSalary() != null) updateEmployee.setSalary(employee.getSalary());
            return String.format("Updated Employee with %d and %s Successfully", employee.getEmpId(), employee.getEmpName());
        }
        return String.format("Employee with %d and %s does not exists", employee.getEmpId(), employee.getEmpName());
    }
}
