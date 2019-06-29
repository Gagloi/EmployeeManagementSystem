package software.jevera.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.jevera.domain.EmployeeSkill;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
}
