package com.deepak.manyToManyUnidirectional.Repository;

import com.deepak.manyToManyUnidirectional.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
