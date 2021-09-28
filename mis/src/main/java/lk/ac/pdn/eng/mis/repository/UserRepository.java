package lk.ac.pdn.eng.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import lk.ac.pdn.eng.mis.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.username = ?1")
	public User findByUsername(String username);

	User findById(long id);

	@Query("select u from User u where u.email = ?1")
	public User findByEmail(String email);
	
	@Query("select u from User u where u.workCategoryId like %:no%")
	//List<User> getEmailListofOfficersByWCID(int i);
	List<User> findByWorkCategoryIdLike(@Param("no") String no);
}
