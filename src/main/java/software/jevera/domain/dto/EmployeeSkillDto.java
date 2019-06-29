package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkillDto {

    private Long skillId;

    private Integer proficiencyLevel;

    @DateTimeFormat(pattern = "yyyy")
    private Date recentYearOfExperience;

}
