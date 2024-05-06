package hwagae.psp.repository;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 카테고리 타입별로 개수 세기
    long countByCategoryType(CategoryType categoryType);

    Optional<Category> findByName(String keyword);

    List<Category> findAllByNameContaining(String keyword);
}
