package com.sacral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacral.model.ComplianceOfficer;
import com.sacral.repository.ComplianceOfficerRepository;

@Service
public class ComplianceOfficerService {

    @Autowired
    private ComplianceOfficerRepository complianceOfficerRepository;

    public List<ComplianceOfficer> searchByNameOrEmail(String name) {
        return complianceOfficerRepository.searchByNameOrEmail(name);
    }

    public List<ComplianceOfficer> findAllByOrderByFirstNameAsc() {
        return complianceOfficerRepository.findAllByOrderByFirstNameAsc();
    }

    public List<ComplianceOfficer> findTop10ByOrderByFirstNameAsc() {
        return complianceOfficerRepository.findTop10ByOrderByFirstNameAsc();
    }

    public List<ComplianceOfficer> findTop20ByOrderByFirstNameAsc() {
        return complianceOfficerRepository.findTop20ByOrderByFirstNameAsc();
    }

    public List<ComplianceOfficer> findTop40ByOrderByFirstNameAsc() {
        return complianceOfficerRepository.findTop40ByOrderByFirstNameAsc();
    }

    public List<ComplianceOfficer> findTop100ByOrderByFirstNameAsc() {
        return complianceOfficerRepository.findTop100ByOrderByFirstNameAsc();
    }
    
    public List<ComplianceOfficer> findByRole(String role) {
        return complianceOfficerRepository.findByRole(role);
    }
    
    public List<ComplianceOfficer> findByArchived(boolean archived) {
        return complianceOfficerRepository.findByArchived(archived);
    }
}