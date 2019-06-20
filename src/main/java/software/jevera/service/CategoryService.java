package software.jevera.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.CategoryRepository;
import software.jevera.dao.EmployeeRepository;
import software.jevera.domain.Category;
import software.jevera.domain.Employee;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFound());
    }

    public List<Category> findAll() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

}
