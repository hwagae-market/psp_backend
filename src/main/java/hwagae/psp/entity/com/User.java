package hwagae.psp.entity.com;

import hwagae.psp.entity.Problem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    List<Problem> createdProblem = new ArrayList<>();

    @OneToMany(mappedBy = "solve", cascade = CascadeType.ALL)
    List<Problem> solvedProblem = new ArrayList<>();
}
