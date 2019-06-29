package software.jevera.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeSkill implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Min(value = 1)
    @Max(value = 4)
    private Integer proficiencyLevel;

    @DateTimeFormat(pattern = "yyyy")
    private Date recentYearOfExperience;

    public EmployeeSkill(Skill skill, Employee employee, Integer proficiencyLevel, Date recentYearOfExperience) {
        this.skill = skill;
        this.employee = employee;
        this.proficiencyLevel = proficiencyLevel;
        this.recentYearOfExperience = recentYearOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkill that = (EmployeeSkill) o;
        return
                Objects.equals(skill.getName(), that.skill.getName()) &&
                Objects.equals(employee.getFullName(), that.employee.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, employee);
    }

}
