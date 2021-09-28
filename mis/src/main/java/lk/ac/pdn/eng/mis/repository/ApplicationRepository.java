package lk.ac.pdn.eng.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	@Query("select a from Application a where a.applicationId = ?1")
	Application findByApplicationId(int id);
	
	@Query("select a from Application a where a.registrationNo = ?1")
	List<Application> findApplicationByRegNo(String regNo);

	@Query("select a from Application a where a.date = ?1")
	Application findByDate(String date);

	@Query("select a from Application a where a.status = ?1")
	List<Application> findByStatus(String status);
	
}
