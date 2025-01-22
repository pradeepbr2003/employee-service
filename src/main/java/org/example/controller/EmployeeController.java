package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
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
        log.info("Invoked {} : getAllEmployees method", this.getClass().getName());
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Integer id) {
        log.info("Invoked {} : getEmployeeById method passed in id : {}", this.getClass().getName(),id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        log.info("Invoked {} : deleteEmployeeById passed in id : {}", this.getClass().getName(),id);
        String message = employeeService.deleteEmployeeById(id);
        log.info("message :  {}", message);
        return ResponseEntity.ok(message);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        log.info("Invoked {} : updateEmployee ", this.getClass().getName());
        String message = employeeService.updateEmployee(employee);
        log.info("Updated Employee : {}", message);
        return ResponseEntity.ok(message);
    }
}
