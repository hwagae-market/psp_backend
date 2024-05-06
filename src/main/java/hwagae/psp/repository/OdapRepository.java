package hwagae.psp.repository;

import hwagae.psp.entity.Odap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdapRepository extends JpaRepository<Odap, Long> {
}
