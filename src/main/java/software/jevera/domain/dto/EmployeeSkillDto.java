package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkillDto implements Serializable {

    private Long skillId;

    private Integer proficiencyLevel;

    @DateTimeFormat(pattern = "yyyy")
    private Date recentYearOfExperience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSkillDto that = (EmployeeSkillDto) o;
        return Objects.equals(skillId, that.skillId) &&
                Objects.equals(proficiencyLevel, that.proficiencyLevel) &&
                Objects.equals(recentYearOfExperience, that.recentYearOfExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, proficiencyLevel, recentYearOfExperience);
    }
}
