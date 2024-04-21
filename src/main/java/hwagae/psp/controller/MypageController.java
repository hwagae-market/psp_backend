package hwagae.psp.controller;

import hwagae.psp.entity.Problem;
import hwagae.psp.entity.com.User;
import hwagae.psp.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MypageController {
    /**
     * 마이페이지
     * 정보수정
     * 푼문제
     * 낸문제
     */

    private final MyPageService mypageService;

    public List<Problem> getSolvedProblem(User user){
        return mypageService.getSolvedProblem(user);
    }

    public List<Problem> getCreatedProblem(User user){
        return mypageService.getCreatedProblem(user);
    }
}