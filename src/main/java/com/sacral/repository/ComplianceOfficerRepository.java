package com.sacral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sacral.model.ComplianceOfficer;

public interface ComplianceOfficerRepository extends JpaRepository<ComplianceOfficer, Long> {
    
    @Query("SELECT c FROM ComplianceOfficer c WHERE c.firstName LIKE ?1 OR c.lastName LIKE ?1 OR c.middleName LIKE ?1 OR c.email LIKE ?1 OR c.mobileNumber LIKE ?1 OR c.phoneNumber LIKE ?1 OR c.PAN LIKE ?1 OR c.aadhar LIKE ?1 OR c.otherId LIKE ?1")
    List<ComplianceOfficer> searchByNameOrEmail(String name);
    
    List<ComplianceOfficer> findAllByOrderByFirstNameAsc();
    
    List<ComplianceOfficer> findTop10ByOrderByFirstNameAsc();
    
    List<ComplianceOfficer> findTop20ByOrderByFirstNameAsc();
    
    List<ComplianceOfficer> findTop40ByOrderByFirstNameAsc();
    
    List<ComplianceOfficer> findTop100ByOrderByFirstNameAsc();
    
    List<ComplianceOfficer> findByRole(String role);
    
    List<ComplianceOfficer> findByArchived(boolean archived);
    
}