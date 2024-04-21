package hwagae.psp.controller;

import hwagae.psp.entity.com.User;
import hwagae.psp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    /**
     * 회원가입
     * 로그인
     * 로그아웃
     * 회원탈퇴
     * 정보수정
     *
     * 메인페이지
     *
     * 로그인/가입/로그아웃/정보수정
     *
     * 마이페이지
     *
     * 카테고리
     */

    private final UserService userService;

    public void join(User user){
        userService.join(user);
    }

    public void login(User user){
        userService.login(user);
    }

    public void logout(User user){
        //세션에서 삭제
    }

    public void delete(User user){
        userService.delete(user);
    }

    public void edit(User user){
        userService.edit(user);
    }

}
