package com.deepak.manyToManyBidirectional.Repository;

import com.deepak.manyToManyBidirectional.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
