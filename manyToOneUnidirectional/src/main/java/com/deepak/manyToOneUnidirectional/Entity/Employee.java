package com.deepak.manyToOneUnidirectional.Entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private Address address;


    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long id) {
        this.empId = empId;
    }

}
