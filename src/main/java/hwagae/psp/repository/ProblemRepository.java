package hwagae.psp.repository;

import hwagae.psp.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository<T extends Problem> extends JpaRepository<T, Long> {
}
