package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.jevera.domain.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private String name;

    public CategoryDto(Category category){
        this.name = category.getName();
    }

}
