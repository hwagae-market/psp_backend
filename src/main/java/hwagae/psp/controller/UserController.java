package hwagae.psp.controller;

import hwagae.psp.entity.User;
import hwagae.psp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String save(User user) {
        userService.save(user);

        return "생성 완료";
    }
}
