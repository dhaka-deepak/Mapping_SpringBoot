package com.deepak.manyToOneBidirectional.Repository;

import com.deepak.manyToOneBidirectional.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
