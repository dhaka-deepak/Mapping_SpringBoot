package com.deepak.oneToManyUnidirectional.Controller;

import com.deepak.oneToManyUnidirectional.Entity.Employee;
import com.deepak.oneToManyUnidirectional.Repository.AddressRepository;
import com.deepak.oneToManyUnidirectional.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository empRepository;

    @PostMapping("/saveEmployees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
        empRepository.saveAll(empData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return empRepository.findAll();
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = empRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        if (empRepository.existsById(id)) {
            updatedEmployee.setEmpId(id);
            empRepository.save(updatedEmployee);
            return ResponseEntity.ok("Employee updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteAllEmployees")
    public ResponseEntity<String> deleteAllEmployees() {
        empRepository.deleteAll();
        return ResponseEntity.ok("All Data Deleted");
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable Long id) {
        Optional<Employee> employee = empRepository.findById(id);
        if (employee.isPresent()) {
            empRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
