package hwagae.psp.repository;

import hwagae.psp.entity.SubjectiveSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectiveSolutionRepository extends JpaRepository<SubjectiveSolution, Long> {
}
