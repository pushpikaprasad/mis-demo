package lk.ac.pdn.eng.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Ar;

@Repository
public interface ArRepository extends JpaRepository<Ar, Long>{

	Ar findById(long arId);

	@Query("select u from User u where u.username = ?1")
	Ar getArByUsername(String username);
}