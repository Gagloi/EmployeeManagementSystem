package software.jevera.domain.mapping;

import software.jevera.domain.Skill;
import software.jevera.domain.dto.SkillDto;

public interface SkillMapper {

    Skill toSkill(SkillDto skillDto);

    Skill setValuesToSkill(Skill skill, SkillDto skillDto);

}
