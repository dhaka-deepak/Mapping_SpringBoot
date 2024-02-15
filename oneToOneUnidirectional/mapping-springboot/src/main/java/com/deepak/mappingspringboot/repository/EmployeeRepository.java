package com.deepak.mappingspringboot.repository;

import com.deepak.mappingspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
