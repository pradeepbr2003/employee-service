package org.example.controller;

import org.example.dto.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        String message = employeeService.addEmployee(employee);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        String message = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(message);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        String message = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(message);
    }
}
