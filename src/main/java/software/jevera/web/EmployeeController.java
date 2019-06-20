package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import software.jevera.domain.Employee;
import software.jevera.domain.Skill;
import software.jevera.service.EmployeeService;
import software.jevera.service.SkillService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/api/employee")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final HttpSession httpSession;
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteById(id);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

}
