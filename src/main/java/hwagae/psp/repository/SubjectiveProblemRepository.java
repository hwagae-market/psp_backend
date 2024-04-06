package hwagae.psp.repository;

import hwagae.psp.entity.SubjectiveProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectiveProblemRepository extends JpaRepository<SubjectiveProblem, Long> {
}
