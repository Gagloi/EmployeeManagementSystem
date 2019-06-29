package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import software.jevera.domain.Skill;
import software.jevera.domain.dto.SkillDto;
import software.jevera.service.SkillService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/api/skills")
@RestController
@RequiredArgsConstructor
public class SkillController {

    private final HttpSession httpSession;
    private final SkillService skillService;

    @GetMapping
    public List<Skill> findAllSkills(){
        return skillService.findAll();
    }

    @PostMapping
    public Skill createSkill(@RequestBody SkillDto skillDto){
        return skillService.createSkill(skillDto);
    }

    @GetMapping("/{id}")
    public Skill findSkillById(@PathVariable Long id){
        return skillService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillById(@PathVariable Long id){
        skillService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@RequestBody SkillDto skill, @PathVariable Long id){
        return skillService.update(skill, id);
    }

}
