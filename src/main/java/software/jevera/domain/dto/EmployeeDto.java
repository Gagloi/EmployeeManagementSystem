package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.jevera.domain.Employee;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String fullName;

    private Date dateOfBirth;

    private String sex;

    private String nationality;

    private String workLocation;

    private String currentPosition;

    private Date startYearOfProfessionalExperience;

    private Set<EmployeeSkillDto> skillId = new HashSet<>(0);

    public EmployeeDto(Employee employee){
        this.fullName = employee.getFullName();
        this.dateOfBirth = employee.getDateOfBirth();
        this.sex = employee.getSex();
        this.currentPosition = employee.getCurrentPosition();
        this.nationality = employee.getNationality();
        this.workLocation = employee.getWorkLocation();
        this.startYearOfProfessionalExperience = employee.getStartYearOfProfessionalExperience();
    }

}
