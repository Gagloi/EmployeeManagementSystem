package software.jevera.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import software.jevera.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
