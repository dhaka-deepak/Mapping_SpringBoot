package com.deepak.oneToManyBidrectional.Repository;

import com.deepak.oneToManyBidrectional.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
