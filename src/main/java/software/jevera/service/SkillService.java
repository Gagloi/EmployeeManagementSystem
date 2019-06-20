package software.jevera.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.SkillRepository;
import software.jevera.domain.Skill;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
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
}
