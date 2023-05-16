package com.sacral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.model.ComplianceOfficer;
import com.sacral.service.ComplianceOfficerService;

@RestController
public class ComplianceOfficerController {

    @Autowired
    private ComplianceOfficerService complianceOfficerService;

    @GetMapping("/compliance-officers/search")
    public List<ComplianceOfficer> searchByNameOrEmail(@RequestParam String name) {
        return complianceOfficerService.searchByNameOrEmail(name);
    }

    @GetMapping("/compliance-officers/find-all")
    public List<ComplianceOfficer> findAllByOrderByFirstNameAsc() {
        return complianceOfficerService.findAllByOrderByFirstNameAsc();
    }

    @GetMapping("/compliance-officers/find-top-10")
    public List<ComplianceOfficer> findTop10ByOrderByFirstNameAsc() {
        return complianceOfficerService.findTop10ByOrderByFirstNameAsc();
    }

    @GetMapping("/compliance-officers/find-top-20")
    public List<ComplianceOfficer> findTop20ByOrderByFirstNameAsc() {
        return complianceOfficerService.findTop20ByOrderByFirstNameAsc();
    }

    @GetMapping("/compliance-officers/find-top-40")
    public List<ComplianceOfficer> findTop40ByOrderByFirstNameAsc() {
        return complianceOfficerService.findTop40ByOrderByFirstNameAsc();
    }

    @GetMapping("/compliance-officers/find-top-100")
    public List<ComplianceOfficer> findTop100ByOrderByFirstNameAsc() {
        return complianceOfficerService.findTop100ByOrderByFirstNameAsc();
    }
    
    @GetMapping("/compliance-officers/find-by-role")
    public List<ComplianceOfficer> findByRole(@RequestParam String role) {
        return complianceOfficerService.findByRole(role);
    }
    
    @GetMapping("/compliance-officers/find-by-archived")
    public List<ComplianceOfficer> findByArchived(@RequestParam boolean archived) {
        return complianceOfficerService.findByArchived(archived);
    }

}