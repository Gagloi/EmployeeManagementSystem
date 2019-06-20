package software.jevera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


public class EmployeeSkill {

    private Integer proficiencyLevel;

    private Date recentYearExperience;

    private Skill skill;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Integer proficiencyLevel, Date recentYearExperience, Skill skill) {
        this.proficiencyLevel = proficiencyLevel;
        this.recentYearExperience = recentYearExperience;
        this.skill = skill;
    }

    public Integer getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(Integer proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Date getRecentYearExperience() {
        return recentYearExperience;
    }

    public void setRecentYearExperience(Date recentYearExperience) {
        this.recentYearExperience = recentYearExperience;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
