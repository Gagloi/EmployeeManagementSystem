package software.jevera.domain.mapping.mapper;

import software.jevera.domain.Skill;
import software.jevera.domain.dto.SkillDto;
import software.jevera.domain.mapping.CategoryMapper;
import software.jevera.domain.mapping.SkillMapper;

public class SkillMapperImpl implements SkillMapper {

    private CategoryMapper categoryMapper = new CategoryMapperImpl();

    @Override
    public Skill toSkill(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setName(skillDto.getName());
        skill.setSkillType(skillDto.getSkillType());
        skill.setCategory(categoryMapper.toCategory(skillDto.getCategory()));
        return skill;
    }

    @Override
    public Skill setValuesToSkill(Skill skill, SkillDto skillDto) {
        skill.setName(skillDto.getName());
        skill.setSkillType(skillDto.getSkillType());
        skill.setCategory(categoryMapper.toCategory(skillDto.getCategory()));
        return skill;
    }
}
