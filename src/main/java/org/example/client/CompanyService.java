package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("COMPANY-SERVICE")
public interface CompanyService {
    @GetMapping("/company")
    public List<Company> getAllCompanies();

    @GetMapping("/company/{employeeId}")
    public String getCompanyName(@PathVariable Integer employeeId);
}
