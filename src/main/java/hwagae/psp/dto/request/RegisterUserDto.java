package hwagae.psp.dto.request;

import hwagae.psp.entity.User;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;
    private String password;
    private String email;
    private String nickname;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();
    }
}
