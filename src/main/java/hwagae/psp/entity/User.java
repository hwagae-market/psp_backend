package hwagae.psp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

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
}
