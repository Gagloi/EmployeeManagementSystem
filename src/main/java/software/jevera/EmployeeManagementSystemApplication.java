package software.jevera;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import software.jevera.domain.Employee;
import software.jevera.domain.Skill;
import software.jevera.service.EmployeeService;
import software.jevera.service.SkillService;

@SpringBootApplication
@Slf4j
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}
