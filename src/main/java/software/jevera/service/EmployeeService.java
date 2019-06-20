package software.jevera.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import software.jevera.dao.EmployeeRepository;
import software.jevera.domain.Employee;
import software.jevera.exceptions.EmployeeAlreadyExist;
import software.jevera.exceptions.EmployeeDoesNoExist;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        if(!employeeHasId(employee)) {
            return employeeRepository.save(employee);
        }else{
            throw new EmployeeAlreadyExist();
        }
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFound());
    }

    public List<Employee> findAll() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    public void deleteById(Long id) {
        if (findById(id) != null) {
            employeeRepository.deleteById(id);
        } else {
            throw new EntityNotFound();
        }
    }

    public Employee update(Employee employee) {
        if(employeeHasId(employee)) {
            return employeeRepository.save(employee);
        }else{
            throw new EmployeeDoesNoExist();
        }
    }

    private boolean employeeHasId(Employee employee){
        return employee.getId() != null;
    }

}
