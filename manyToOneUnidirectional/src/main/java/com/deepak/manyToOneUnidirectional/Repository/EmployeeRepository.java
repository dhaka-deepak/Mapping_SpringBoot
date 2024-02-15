package com.deepak.manyToOneUnidirectional.Repository;

import com.deepak.manyToOneUnidirectional.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
