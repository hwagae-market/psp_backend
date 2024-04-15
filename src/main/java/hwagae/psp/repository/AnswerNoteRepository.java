package hwagae.psp.repository;

import hwagae.psp.entity.AnswerNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerNoteRepository extends JpaRepository<AnswerNote, Long> {
}
