package com.deepak.mappingspringboot.entity;

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

//    for bidirectional one to one mapping
//    @OneToOne(mappedBy = "address")
//    private Employee employee;
}
