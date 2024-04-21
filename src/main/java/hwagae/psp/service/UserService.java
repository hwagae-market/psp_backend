package hwagae.psp.service;

import hwagae.psp.entity.com.User;
import hwagae.psp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public void join(User user) {
        userRepository.save(user);
    }

    public void login(User user) {
        userRepository.findById(user.getId());

        //not find -> 없는 회원임.


    }

    public void delete(User user) {
        userRepository.delete(user);


    }

    public void edit(User user) {
        User findUser = userRepository.findById(user.getId()).get();

        updateMemberInfo(findUser, user);
    }

    private void updateMemberInfo(User findUser, User user) {
        if(!user.getEmail().isEmpty()) {
            findUser.setEmail(user.getEmail());
        }
        if(!user.getNickname().isEmpty()){
            findUser.setNickname(user.getNickname());
        }
        if (!user.getUsername().isEmpty()) {
            findUser.setUsername(user.getUsername());
        }
    }
}
