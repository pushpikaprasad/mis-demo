package lk.ac.pdn.eng.mis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Officer;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Long>{

	Officer findById(long officerId);

	@Query("select u from User u where u.username = ?1")
	Officer getOfficerByUsername(String username);
	
	@Query("select u from User u where u.email = ?1")
	Officer getOfficerByEmail(String email);
	
}