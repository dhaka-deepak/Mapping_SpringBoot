package com.deepak.manyToOneBidirectional.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;
    private String empName;
    private Integer empAge;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")  // Referencing the foreign key column in Employee
    @JsonBackReference
    private Address address;


    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long id) {
        this.empId = empId;
    }
}
