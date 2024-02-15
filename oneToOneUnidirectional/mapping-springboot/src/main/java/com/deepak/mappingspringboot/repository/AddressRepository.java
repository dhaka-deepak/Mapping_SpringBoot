package com.deepak.mappingspringboot.repository;

import com.deepak.mappingspringboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
