package org.example;

import org.example.dto.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    public List<Employee> employeeBean() {
        String names[] = {"Pradeep", "Deepak", "Pratap", "Leena", "Reeta", "Anu", "Roopa", "Lakshmi", "Suresh", "Rama", "Lakshman"};
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 100; i < 111; i++) {
            Employee employee = Employee.builder().empId(i).empName(names[i - 100]).salary(i * 100.12).build();
            employeeList.add(employee);
        }
        return employeeList;
    }
}
