package hwagae.psp.repository;

import hwagae.psp.entity.MultipleProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleProblemRepository extends JpaRepository<MultipleProblem, Long> {
}
