package com.capg.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long>{

	Optional<Vendor> findByusername(String username);
	//Optional<Vendor> findByUsernameAndEmail(String username, String email);

	Optional<Vendor> findByemail(String username);

}