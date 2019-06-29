package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import software.jevera.domain.Employee;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.service.EmployeeService;

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
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/findByQuery/{query}")
    public List<Employee> findEmployeeBySkill(@RequestParam(value = "query[]") String[] query, Integer pageNumber, Integer itemsSize){
        return employeeService.findBySkill(query, pageNumber, itemsSize);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody EmployeeDto employeeDto, Long id) {
        return employeeService.update(employeeDto, id);
    }

}
