package software.jevera.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.jpa.CategoryRepository;
import software.jevera.dao.jpa.SkillRepository;
import software.jevera.domain.Skill;
import software.jevera.domain.dto.SkillDto;
import software.jevera.domain.mapping.CategoryMapper;
import software.jevera.domain.mapping.SkillMapper;
import software.jevera.exceptions.BusinessException;
import software.jevera.exceptions.EntityNotFound;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public Skill createSkill(SkillDto skillDto) {
        Skill skill = skillMapper.toSkill(skillDto);
        if(skillCategoryExist(skill)) {
            skill.setCategory(categoryRepository.findByName(skill.getCategory().getName()).get());
            if(skillUniqueWithinCategory(skill)) {
                log.info("Create skill: {}", skill);
                return skillRepository.save(skill);
            }else{
                throw new BusinessException("Skill does not unique within category");
            }
        }else{
            throw new BusinessException("Category does no exist");
        }
    }

    public Skill findById(Long id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new EntityNotFound("Can not find skill by id"));
        log.info("Find by id skill: {}", skill);
        return skill;
    }

    public List<Skill> findAll() {
        ArrayList<Skill> skills = Lists.newArrayList(skillRepository.findAll());
        log.info("Find all skills: {}", skills);
        return skills;
    }

    public void deleteById(Long id) {
        if (skillRepository.existsById(id)) {
            log.info("Skill with id: " + id + " was deleted");
            skillRepository.deleteById(id);
        }else {
            throw new EntityNotFound("Can not find skill by id: " + id);
        }
    }

    public Skill update(SkillDto skillDto, Long id) {
        if(skillRepository.existsById(id)) {
            Skill skill = skillRepository.getOne(id);
            skill.setCategory(categoryRepository.findByName(skillDto.getCategory().getName()).orElseThrow(() -> new EntityNotFound("Category dont found")));
            skill.setName(skillDto.getName());
            log.info("Updated skill: {}", skill);
            return skillRepository.save(skill);
        }else {
            throw new EntityNotFound("Can not find skill by id: " + id);
        }
    }

    private boolean skillCategoryExist(Skill skill){
        return categoryRepository.findByName(skill.getCategory().getName()).isPresent();
    }

    private boolean skillUniqueWithinCategory(Skill skill){
        return skillRepository.findByCategory(skill.getCategory())
                .stream()
                .noneMatch(it -> it.getName().equals(skill.getName()));
    }

}
