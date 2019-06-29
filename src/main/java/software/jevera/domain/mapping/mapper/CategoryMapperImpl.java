package software.jevera.domain.mapping.mapper;

import software.jevera.domain.Category;
import software.jevera.domain.dto.CategoryDto;
import software.jevera.domain.mapping.CategoryMapper;

public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category toCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    @Override
    public CategoryDto toCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
