package software.jevera.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import software.jevera.dao.jpa.EmployeeRepository;
import software.jevera.dao.jpa.EmployeeSkillRepository;
import software.jevera.dao.jpa.SkillRepository;
import software.jevera.domain.Employee;
import software.jevera.domain.EmployeeSkill;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.domain.mapping.EmployeeMapper;
import software.jevera.exceptions.EntityNotFound;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


//import software.jevera.dao.jpa.EmployeeSkillRepository;
//import software.jevera.dao.jpa.EmployeeSkillRepository;

@Service
@Slf4j
@Transactional
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SkillRepository skillRepository;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEmployee(employeeDto);
        if(!employeeDto.getSkillId().isEmpty()) {
            employee.setSkills(addExistingSkills(employee, employeeDto));
        }
        log.info("Create employee: {}", employeeMapper.toEmployeeDto(employee));
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFound("Can not find employee by id"));
        log.info("Find employee by id: {}", employeeMapper.toEmployeeDto(employee));
        return employee;
    }

    public List<Employee> findAll() {
        List<Employee> all = Lists.newArrayList(employeeRepository.findAll());
        log.info("All employees: {}",all.stream().map(employeeMapper::toEmployeeDto).collect(Collectors.toList()));
        return all;
    }

    public void deleteById(Long id) {
        if (findById(id) != null) {
            log.info("Employee with id: " + id + " was deleted!");
            employeeRepository.deleteById(id);
        } else {
            throw new EntityNotFound("Can not find employee by id");
        }
    }

    @Transactional
    public Employee update(EmployeeDto employeeDto, Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            log.info("{}", employeeDto);
            employeeMapper.setEmployee(employee.get(), employeeDto);
            if (!employeeDto.getSkillId().isEmpty()) {
                employee.get().getSkills()
                        .stream()
                        .forEach(it -> employeeSkillRepository.deleteById(it.getId()));
                employee.get().setSkills(addExistingSkills(employee.get(), employeeDto));
            }
            log.info("Updated employee: {}", employeeMapper.toEmployeeDto(employee.get()));
        }else {
            throw new EntityNotFound("Entity not found");
        }
        return employeeRepository.save(employee.get());
    }

    public List<Employee> findBySkill(String[] query, Integer pageNumber, Integer itemsCount) {
        if(pageNumber == null && itemsCount == null){
            pageNumber = 0;
            itemsCount = Integer.MAX_VALUE;
        }
        Set<Employee> set = new HashSet<>();
        for (String s: query){
            set.addAll(employeeRepository.findEmployeesBySkill(s, PageRequest.of(pageNumber, itemsCount)));
        }

        Map<EmployeeDto, Integer> sortingEmployeeDtoByProfLvl = new HashMap<>();

        Arrays.stream(query).forEach(str -> {
            set.stream()
                    .forEach(employee -> {
                        Integer sumProficiencyLevel = 0;
                        for (EmployeeSkill es : employee.getSkills()) {
                            if (es.getSkill().getName().equals(str)){
                                sumProficiencyLevel += es.getProficiencyLevel();
                                sortingEmployeeDtoByProfLvl.put(employeeMapper.toEmployeeDto(employee), sumProficiencyLevel);
                            }
                        }
                    });
        });

        LinkedHashMap<EmployeeDto, Integer> sortedEmployeeDtos = sortingEmployeeDtoByProfLvl
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)
                );

        List<Employee> resultSortedList = new ArrayList<>();
        sortedEmployeeDtos.keySet()
                .stream()
                .forEach(employeeDto -> resultSortedList.add(employeeRepository.findByFullName(employeeDto.getFullName()).get()));
        log.info("Sorted employees: {}",resultSortedList
                .stream()
                .map(employeeMapper::toEmployeeDto)
                .collect(Collectors.toList()));
        return resultSortedList;
    }



    private Set<EmployeeSkill> addExistingSkills(Employee employee, EmployeeDto employeeDto){
        Set<EmployeeSkill> employeeSkills = new HashSet<>();
        employeeDto.getSkillId()
                .stream()
                .forEach(it -> employeeSkills.add(new EmployeeSkill(skillRepository.getOne(it.getSkillId()), employee, it.getProficiencyLevel(), it.getRecentYearOfExperience())));
        return employeeSkills;
    }


}
