package software.jevera.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import software.jevera.dao.jpa.EmployeeRepository;
import software.jevera.domain.Employee;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.domain.mapping.EmployeeMapper;
import software.jevera.domain.mapping.mapper.EmployeeMapperImpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeMapper employeeMapper;

    @MockBean
    private EmployeeRepository employeeRepository;



    @Test
    public void createEmployee() {
        EmployeeDto employeeDto = new EmployeeDto("Sergey Baginskiy", Date.from(Instant.now()), "male", "Ukraine", "Chernihiv", "Java june", Date.from(Instant.now()), new ArrayList<>());
        Mockito.when(employeeMapper.toEmployee(employeeDto)).thenReturn(createInstance());
        log.info("{}", employeeDto);
        Employee employee = employeeService.createEmployee(employeeDto);
        Mockito.verify(employeeRepository).save(employeeMapper.toEmployee(employeeDto));
        assertEquals(employee, employeeService.createEmployee(employeeDto));
    }

    @Test
    public void findById() {
        Employee employee = createInstance();
        employee.setId(123L);
        Mockito.when(employeeRepository.findById(123L)).thenReturn(Optional.of(employee));
        assertEquals(employeeService.findById(123L), employee);
    }

    @Test
    public void findAll() {
        Employee employee = createInstance();
        Employee employee1 = createInstance();
        employee1.setFullName("New Full Name");
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employee1);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        assertEquals(employeeService.findAll(), employeeList);

    }

    @Test
    public void deleteById() {
        Employee employee = createInstance();
        Mockito.when(employeeMapper.toEmployeeDto(employee)).thenReturn(new EmployeeDto(createInstance()));
        employeeService.createEmployee(employeeMapper.toEmployeeDto(employee));
        assertFalse(employeeRepository.existsById(employee.getId()));
    }

    @Test
    public void update() {
        Employee employee = createInstance();
        Mockito.when(employeeMapper.toEmployeeDto(employee)).thenReturn(new EmployeeDto(createInstance()));
        employeeService.createEmployee(employeeMapper.toEmployeeDto(employee));
        Employee updatedEmployee = employee;
        updatedEmployee.setFullName("Ne Full name");
        Mockito.when(employeeMapper.toEmployeeDto(updatedEmployee)).thenReturn(new EmployeeDto(updatedEmployee));
        EmployeeDto employeeDto = employeeMapper.toEmployeeDto(updatedEmployee);
        Mockito.when(employeeRepository.findById(updatedEmployee.getId())).thenReturn(Optional.of(updatedEmployee));
        Mockito.when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);
        employee = employeeService.update(employeeMapper.toEmployeeDto(updatedEmployee), updatedEmployee.getId());
        assertEquals(updatedEmployee, employee);
    }


    private Employee createInstance(){
        Employee employee = new Employee("Sergey Baginskiy", Date.from(Instant.now()), "male", "Ukraine", "Chernihiv", "Java june", Date.from(Instant.now()));
        return employee;
    }

}