package software.jevera.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.jpa.CategoryRepository;
import software.jevera.dao.jpa.SkillRepository;
import software.jevera.domain.Skill;
import software.jevera.exceptions.BusinessException;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
@Slf4j
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Skill createSkill(Skill skill) {
        if(skillCategoryExist(skill)) {
            skill.setCategory(categoryRepository.findByName(skill.getCategory().getName()).get());
            if(skillUniqueWithinCategory(skill)) {
                return skillRepository.save(skill);
            }else{
                throw new BusinessException("Skill does not unique within category");
            }
        }else{
            throw new BusinessException("Category does no exist");
        }
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id).orElseThrow(() -> new EntityNotFound());
    }

    public List<Skill> findAll() {
        return Lists.newArrayList(skillRepository.findAll());
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    public Skill update(Skill skill) {
        return skillRepository.save(skill);
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
