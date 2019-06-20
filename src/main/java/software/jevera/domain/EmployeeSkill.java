package software.jevera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer proficiencyLevel;

    private Date recentYearExperience;

    @OneToOne
    private Skill skill;

    @OneToOne
    private Employee employee;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Long id, Integer proficiencyLevel, Date recentYearExperience, Skill skill, Employee employee) {
        this.id = id;
        this.proficiencyLevel = proficiencyLevel;
        this.recentYearExperience = recentYearExperience;
        this.skill = skill;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
