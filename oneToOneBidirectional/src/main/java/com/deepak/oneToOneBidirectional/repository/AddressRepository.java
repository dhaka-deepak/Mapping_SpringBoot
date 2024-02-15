package com.deepak.oneToOneBidirectional.repository;

import com.deepak.oneToOneBidirectional.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
