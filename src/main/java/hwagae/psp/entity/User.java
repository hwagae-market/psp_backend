package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "users_id")
    private List<Workbook> createWorkbook;

    @OneToMany
    @JoinColumn(name = "workbook_id")
    private List<Workbook> scribeWorkbook;

    public void subscribeWorkbook(Workbook workbook) {
        this.scribeWorkbook.add(workbook);
    }
}
