package com.spring.jwt.springjwt.repository;

import com.spring.jwt.springjwt.models.Employee;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findById(String id);
}