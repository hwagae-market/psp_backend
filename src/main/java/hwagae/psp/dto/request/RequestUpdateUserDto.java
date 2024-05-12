package hwagae.psp.dto.request;

import lombok.Data;

@Data
public class RequestUpdateUserDto {
    private String password;
    private String email;
    private String nickname;
}
