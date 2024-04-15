package hwagae.psp.repository;

import hwagae.psp.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Complain, Long> {
}
