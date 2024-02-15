package com.deepak.oneToManyBidrectional.Controller;

import com.deepak.oneToManyBidrectional.Entity.Address;
import com.deepak.oneToManyBidrectional.Entity.Employee;
import com.deepak.oneToManyBidrectional.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepository;

//    @PostMapping("/saveEmployees")
//    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
//        empRepository.saveAll(empData);
//        return ResponseEntity.ok("Data saved");
//    }

    @PostMapping("/saveEmployees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
        for (Employee employee : empData) {
            for (Address address : employee.getAddress()) {
                address.setEmployee(employee);
            }
        }
        empRepository.saveAll(empData);
        return ResponseEntity.ok("Data saved");
    }


    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return empRepository.findAll();
    }

//    @GetMapping("/getEmployees")
//    public ResponseEntity<List<Employee>> getEmployees() {
//        try {
//            List<Employee> employees = empRepository.findAll();
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();  // Log or print the stack trace
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


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
