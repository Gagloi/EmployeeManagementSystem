package software.jevera.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.jevera.domain.Category;
import software.jevera.domain.mapping.CategoryMapper;
import software.jevera.domain.mapping.EmployeeMapper;
import software.jevera.domain.mapping.SkillMapper;
import software.jevera.domain.mapping.mapper.CategoryMapperImpl;
import software.jevera.domain.mapping.mapper.EmployeeMapperImpl;
import software.jevera.domain.mapping.mapper.SkillMapperImpl;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public EmployeeMapper employeeMapper() {
        EmployeeMapper employeeMapper = new EmployeeMapperImpl();
        return employeeMapper;
    }

    @Bean
    public SkillMapper skillMapper() {
        SkillMapper skillMapper = new SkillMapperImpl();
        return skillMapper;
    }

    @Bean
    public CategoryMapper categoryMapper() {
        CategoryMapper categoryMapper = new CategoryMapperImpl();
        return categoryMapper;
    }


}
