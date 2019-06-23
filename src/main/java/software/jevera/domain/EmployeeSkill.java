package software.jevera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "EmployeeSkillEntity")
@Table(name = "employee_skill")
@NoArgsConstructor
@ToString
public class EmployeeSkill implements Serializable {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private EmployeeSkillIdLol employeeSkillIdLol;

    @Size(min = 1, max = 4)
    private Integer proficiencyLevel;

    @DateTimeFormat(pattern = "yyyy")
    private Date recentYearExperience;

    public EmployeeSkill(Employee employee, Skill skill, Integer proficiencyLevel, Date recentYearExperience) {
        this.employeeSkillIdLol = new EmployeeSkill.EmployeeSkillIdLol();
        this.employeeSkillIdLol.employeeId = employee.getId();
        this.employeeSkillIdLol.skillId = skill.getId();
        this.proficiencyLevel = proficiencyLevel;
        this.recentYearExperience = recentYearExperience;
    }

    @Embeddable
    public static class EmployeeSkillIdLol implements Serializable{

        public Long skillId;

        public Long employeeId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeSkillIdLol that = (EmployeeSkillIdLol) o;
            return Objects.equals(skillId, that.skillId) &&
                    Objects.equals(employeeId, that.employeeId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(skillId, employeeId);
        }
    }

}
