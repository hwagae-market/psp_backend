package hwagae.psp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * 오답노트 엔티티
 */

@Entity
@Getter
public class AnswerNote {
    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    @Setter
    private Problem problem;

    private String submit;
}
