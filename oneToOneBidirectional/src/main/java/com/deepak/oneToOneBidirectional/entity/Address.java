package com.deepak.oneToOneBidirectional.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "add_id")
    private Long addressId;
    private String city;
    private String addressType;

    @OneToOne
    @JoinColumn(name = "fk_add_id")
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
