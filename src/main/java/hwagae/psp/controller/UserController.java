package hwagae.psp.controller;

import hwagae.psp.config.annotation.RequiredAuthenticate;
import hwagae.psp.dto.request.LoginUserDto;
import hwagae.psp.dto.request.RegisterUserDto;
import hwagae.psp.dto.request.RequestUpdateUserDto;
import hwagae.psp.entity.User;
import hwagae.psp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String save(@RequestBody RegisterUserDto registerUser) {
        userService.save(registerUser);

        return "생성 완료";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginUserDto loginUserDto, HttpServletResponse response, HttpServletRequest request) {
        ResponseEntity<Object> login = userService.login(loginUserDto, response);

        return ResponseEntity.ok(login);
    }


    @GetMapping("/login/test")
    @RequiredAuthenticate
    public ResponseEntity<String> loginTest(HttpServletResponse response, HttpServletRequest request) {
        return ResponseEntity.ok("로그인 성공 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/update")
    @RequiredAuthenticate
    public ResponseEntity<String> updateUserInfo(@RequestBody RequestUpdateUserDto updateUser, HttpServletRequest request, HttpServletResponse response) {
        userService.updateUser(request, updateUser);

        return ResponseEntity.ok("정보 업데이트 완료");
    }
}
