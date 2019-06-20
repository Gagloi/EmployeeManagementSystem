package software.jevera.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import software.jevera.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
