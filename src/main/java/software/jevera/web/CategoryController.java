package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import software.jevera.domain.Category;
import software.jevera.domain.Skill;
import software.jevera.domain.dto.CategoryDto;
import software.jevera.domain.dto.EmployeeDto;
import software.jevera.service.CategoryService;
import software.jevera.service.SkillService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/api/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final HttpSession httpSession;
    private final CategoryService categoryService;


    @GetMapping
    public List<Category> findAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryDto category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, CategoryDto categoryDto){
        return categoryService.update(id, categoryDto);
    }


}
