package software.jevera.dao.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import software.jevera.domain.Employee;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByFullName(String fullName);

    @Query("select e from Employee e join e.skills es where es.skill.name like :query ORDER BY es.proficiencyLevel DESC, es.skill.name DESC")
    List<Employee> findEmployeesBySkill(@Param("query") String query, Pageable pageable);

}
