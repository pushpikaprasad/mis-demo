package lk.ac.pdn.eng.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findById(long adminId);
	
	/*@Modifying(clearAutomatically = true)
	@Query("update User u set u.password = :password "
			+ ", u.firstName = :firstName "
			+ ", u.lastName = :lastName "
			+ ", u.address = :address "
			+ ", u.email = :email "
			+ ", u.mobileNumber = :mobileNumber "
			+ ", u.nic = :nic "
			+ " where u.username = :username")
	void updateAdmin(@Param("username") String username,@Param("password") String password,@Param("firstName") String firstName,
			@Param("lastName") String lastName,@Param("address") String address,
			@Param("email") String email,@Param("mobileNumber")  String mobileNumber,@Param("nic") String nic);
	*/
	
	@Query("select u from User u where u.username = ?1")
	Admin findByUsername(String username);
	
}