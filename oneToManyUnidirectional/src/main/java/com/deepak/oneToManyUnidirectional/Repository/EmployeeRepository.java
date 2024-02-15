package com.deepak.oneToManyUnidirectional.Repository;

import com.deepak.oneToManyUnidirectional.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
