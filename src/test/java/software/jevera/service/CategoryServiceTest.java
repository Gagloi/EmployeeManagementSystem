package software.jevera.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import software.jevera.dao.jpa.CategoryRepository;
import software.jevera.domain.Category;
import software.jevera.domain.Employee;
import software.jevera.domain.dto.CategoryDto;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.domain.mapping.CategoryMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


//    @Test
//    public void createCategory() {
//
//        CategoryDto categoryDto = new CategoryDto("category");
//        Category category = categoryMapper.toCategory(categoryDto);
//        Mockito.when(categoryRepository.save(category)).thenReturn(category);
//        categoryService.createCategory(categoryDto);
//        Mockito.verify(categoryRepository).save(categoryMapper.toCategory(categoryDto));
//
//    }

    @Test
    public void findById() {
        Category category = createInstance();
        category.setId(123L);
        Mockito.when(categoryRepository.findById(123L)).thenReturn(Optional.of(category));
        assertEquals(categoryService.findById(123L), category);
    }

    @Test
    public void findAll() {
        Category category = createInstance();
        Category category1 = createInstance();
        category1.setName("New Full Name");
        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(category);
        categoryList.add(category1);
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        assertEquals(categoryService.findAll(), categoryList);

    }

//    @Test
//    public void deleteById() {
//        Category category = createInstance();
//        Mockito.when(categoryMapper.toCategoryDto(category)).thenReturn(new CategoryDto(createInstance()));
//        categoryService.createCategory(categoryMapper.toCategoryDto(category));
//        assertFalse(categoryRepository.existsById(category.getId()));
//    }


    private Category createInstance(){
        Category category = new Category();
        category.setName("category");
        return category;
    }

}