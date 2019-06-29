package software.jevera.domain.mapping;

import software.jevera.domain.Employee;
import software.jevera.domain.dto.EmployeeDto;

public interface EmployeeMapper {

    Employee toEmployee(EmployeeDto employeeDto);

    EmployeeDto toEmployeeDto(Employee employee);

    void setEmployee(Employee employee, EmployeeDto employeeDto);
}
