package software.jevera.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import software.jevera.domain.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
}
