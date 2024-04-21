package hwagae.psp.service;

import hwagae.psp.entity.Problem;
import hwagae.psp.entity.com.User;
import hwagae.psp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final UserRepository userRepository;
    public List<Problem> getSolvedProblem(User user) {
        return userRepository.findById(user.getId()).get().getSolvedProblem();
    }

    public List<Problem> getCreatedProblem(User user) {
        return userRepository.findById(user.getId()).get().getCreatedProblem();
    }
}