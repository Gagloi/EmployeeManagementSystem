package software.jevera.domain.mapping.mapper;

import software.jevera.domain.Employee;
import software.jevera.domain.EmployeeSkill;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.domain.dto.EmployeeSkillDto;
import software.jevera.domain.mapping.EmployeeMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeMapperImpl implements EmployeeMapper {


    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        setValues(employee, employeeDto);
        return employee;
    }

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setCurrentPosition(employee.getCurrentPosition());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());
        employeeDto.setFullName(employee.getFullName());
        employeeDto.setNationality(employee.getNationality());
        employeeDto.setSex(employee.getSex());
        employeeDto.setStartYearOfProfessionalExperience(employee.getStartYearOfProfessionalExperience());
        Set<EmployeeSkillDto> employeeSkillDtos = new HashSet<>();
        if(employee.getSkills() != null) {
            employee.getSkills()
                    .stream()
                    .forEach(employeeSkill -> {
                        employeeSkillDtos.add(new EmployeeSkillDto(employeeSkill.getId(), employeeSkill.getProficiencyLevel(), employeeSkill.getRecentYearOfExperience()));
                    });
            employeeDto.setSkillId(employeeSkillDtos);
        }
        return employeeDto;
    }


    @Override
    public void setEmployee(Employee employee, EmployeeDto employeeDto) {
        setValues(employee, employeeDto);
    }

    private void setValues(Employee employee, EmployeeDto employeeDto){
        if(employeeDto.getCurrentPosition() != null) {
            employee.setCurrentPosition(employeeDto.getCurrentPosition());
        }
        if(employeeDto.getDateOfBirth() != null) {
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
        }
        if(employeeDto.getNationality() != null) {
            employee.setNationality(employeeDto.getNationality());
        }
        if(employeeDto.getSex() != null) {
            employee.setSex(employeeDto.getSex());
        }
        if(employeeDto.getStartYearOfProfessionalExperience() != null) {
            employee.setStartYearOfProfessionalExperience(employeeDto.getStartYearOfProfessionalExperience());
        }
        if(employeeDto.getWorkLocation() != null) {
            employee.setWorkLocation(employeeDto.getWorkLocation());
        }
        if(employeeDto.getFullName() != null) {
            employee.setFullName(employeeDto.getFullName());
        }
    }

}
