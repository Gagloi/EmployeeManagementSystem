package software.jevera.domain.mapping;

import software.jevera.domain.Category;
import software.jevera.domain.dto.CategoryDto;

public interface CategoryMapper {

    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);

}
