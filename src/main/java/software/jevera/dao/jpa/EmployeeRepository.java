package software.jevera.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import software.jevera.domain.Employee;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

 //   @Query(value = "SELECT * FROM employees WHERE ")
   // Set<Employee> findEmployeesBySkill(String query);

}
