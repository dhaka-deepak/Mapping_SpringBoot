package com.deepak.manyToOneBidirectional.Repository;

import com.deepak.manyToOneBidirectional.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
