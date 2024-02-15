package com.deepak.oneToOneBidirectional.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;

    // method to set address and establish bidirectional relationship
    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setEmployee(this);
        }
    }

}
