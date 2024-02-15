package com.deepak.manyToManyUnidirectional.Repository;

import com.deepak.manyToManyUnidirectional.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
