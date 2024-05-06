package hwagae.psp.repository;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.Workbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkbookRepository extends JpaRepository<Workbook, Long> {
    List<Workbook> findAllByCategory(Category category);
}
