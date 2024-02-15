package com.deepak.manyToOneUnidirectional.Repository;

import com.deepak.manyToOneUnidirectional.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
