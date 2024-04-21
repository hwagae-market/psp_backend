package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * 사용자 정보 엔티티
 */
@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "users_id")
    @Setter
    private List<Workbook> createWorkbook = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "workbook_id")
    private List<Workbook> scribeWorkbook = new ArrayList<>();

    @OneToMany
    @Setter
    @JoinColumn(name = "answer_note_id")
    private List<AnswerNote> answerNotes = new ArrayList<>();

    public void subscribeWorkbook(Workbook workbook) {
        this.scribeWorkbook.add(workbook);
        workbook.setUser(this);
    }
}
