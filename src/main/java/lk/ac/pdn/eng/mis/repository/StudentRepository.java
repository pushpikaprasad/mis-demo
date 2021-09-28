package lk.ac.pdn.eng.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findById(long stdId);
	
	@Query("select u from User u where u.username = ?1")
	Student findByUsername(String username);
	
	
	
}
