package software.jevera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import software.jevera.domain.Skill;
import software.jevera.service.SkillService;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		SkillService skillService = context.getBean(SkillService.class);
	}

}
