package lk.ac.pdn.eng.mis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.pdn.eng.mis.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	@Query("select emp from Employee emp where emp.email = ?1")
	Employee findEmployeeByEmail(String email);

	@Query("SELECT e FROM Employee as e WHERE (:emNumber is null or e.employeeNumber=:emNumber) and (:empSurname is null or e.surnameWithInitials like %:empSurname%) and " +
			"(:empDesig is null or e.designation like %:empDesig%) and (:presentDivi is null or e.presentDivision1 like %:presentDivi%) and " +
			" (:type is null or e.type=:type)"
	)
	
	List<Employee> findAllByInputString(String emNumber, String empSurname, String empDesig, String presentDivi, String type);
/*
	List<Employee> findByEmployeeNumber(String emNumber);
	List<Employee> findByEmployeeNumberAndSurnameWithInitialsContaining(String emNumber,String empSurname);
	List<Employee> findByEmployeeNumberAndSurnameWithInitialsContainingAndDesignation(String emNumber,String empSurname,String empDesig);
	List<Employee> findByEmployeeNumberAndSurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCase(String emNumber,String empSurname,String empDesig,String presentDivi);
	List<Employee> findByEmployeeNumberAndSurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndType(String emNumber, String empSurname, String empDesig, String presentDivi, String type);
	
	//List<Employee> findByEmployeeNumberAndSurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJob(String emNumber,String empSurname,String empDesig,String presentDivi,String jobNature);
	//List<Employee> findByEmployeeNumberAndSurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJobAndSubject(String emNumber,String empSurname,String empDesig,String presentDivi,String jobNature,String empSubject);
	List<Employee> findBySurnameWithInitialsContaining(String empSurname);
	List<Employee> findBySurnameWithInitialsContainingAndDesignation(String empSurname,String empDesig);
	List<Employee> findBySurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCase(String empSurname,String empDesig,String presentDivi);
	List<Employee> findBySurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndType(String empSurname,String empDesig, String presentDivi, String type);
	
	//List<Employee> findBySurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJob(String empSurname,String empDesig,String presentDivi,String jobNature);
	//List<Employee> findBySurnameWithInitialsContainingAndDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJobAndSubject(String empSurname,String empDesig,String presentDivi,String jobNature,String empSubject);
	List<Employee> findByDesignation(String empDesig);
	List<Employee> findByDesignationAndPresentDivision1ContainingIgnoreCase(String empDesig,String presentDivi);
	List<Employee> findByDesignationAndPresentDivision1ContainingIgnoreCaseAndType(String empDesig, String presentDivi, String type);
	
	//List<Employee> findByDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJob(String empDesig,String presentDivi,String jobNature);
	//List<Employee> findByDesignationAndPresentDivision1ContainingIgnoreCaseAndNatureOfTheJobAndSubject(String empDesig,String presentDivi,String jobNature,String empSubject);
	List<Employee> findByPresentDivision1ContainingIgnoreCase(String presentDivi);
	
	@Query("select emp from Employee emp where emp.presentDivision1 = ?1 and emp.type = ?2")
	List<Employee> findByPresentDivision1ContainingIgnoreCaseAndType(String presentDivi, String type);
	
	//List<Employee> findByPresentDivision1ContainingIgnoreCaseAndNatureOfTheJob(String presentDivi,String jobNature);
	//List<Employee> findByPresentDivision1ContainingIgnoreCaseAndNatureOfTheJobAndSubject(String presentDivi,String jobNature,String empSubject);
	List<Employee> findByType(String type);
	
	//List<Employee> findByNatureOfTheJob(String jobNature);
	//List<Employee> findByNatureOfTheJobAndSubject(String jobNature,String empSubject);
	//List<Employee> findBySubject(String empSubject);
*/
}

