package hwagae.psp.repository;

import hwagae.psp.entity.MultipleSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleSolutionRepository extends JpaRepository<MultipleSolution, Long> {
}
