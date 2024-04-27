package hwagae.psp.repository;

import hwagae.psp.entity.OdapNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdapNoteRepository extends JpaRepository<OdapNote, Long> {
}
