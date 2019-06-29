package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.jevera.domain.SkillType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {

    private String name;

    private SkillType skillType;

    private CategoryDto category;

}
