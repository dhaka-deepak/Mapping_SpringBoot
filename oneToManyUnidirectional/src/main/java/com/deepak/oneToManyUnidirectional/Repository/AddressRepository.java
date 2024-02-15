package com.deepak.oneToManyUnidirectional.Repository;

import com.deepak.oneToManyUnidirectional.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
