package software.jevera.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.jpa.CategoryRepository;
import software.jevera.domain.Category;
import software.jevera.domain.dto.CategoryDto;
import software.jevera.domain.mapping.CategoryMapper;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Category createCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.save(categoryMapper.toCategory(categoryDto));
        log.info("Created category: {}", category);
        return category;
    }

    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFound("Can not find category by id"));
        log.info("Find category by id: {}", category.toString());
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFound("Can not find category by id"));
    }

    public List<Category> findAll() {
        log.info("{}",Lists.newArrayList(categoryRepository.findAll()));
        return Lists.newArrayList(categoryRepository.findAll());
    }

    public void deleteById(Long id) {
        log.info("Category with id: " + id + " was deleted");
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.getOne(id);
        category.setName(categoryDto.getName());
        log.info("Updated category: {}", category);
        return categoryRepository.save(category);
    }

}
