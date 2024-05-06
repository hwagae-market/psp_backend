package hwagae.psp.service;

import hwagae.psp.dto.response.ResponseCountDto;
import hwagae.psp.entity.*;
import hwagae.psp.repository.CategoryRepository;
import hwagae.psp.repository.ProblemRepository;
import hwagae.psp.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CommonServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @BeforeEach
    void before() {
        User user = new User();
        userRepository.save(user);

        Problem problem1 = new MultipleProblem();
        Problem problem2 = SubjectiveProblem.builder().build();
        problemRepository.save(problem1);
        problemRepository.save(problem2);

        Category category = Category.builder().categoryType(CategoryType.LICENSE).build();
        categoryRepository.save(category);
    }

    @Test
    void getCountInfo() {
        ResponseCountDto responseCountDto = new ResponseCountDto(userRepository.count(), problemRepository.count(), categoryRepository.countByCategoryType(CategoryType.LICENSE));

        Assertions.assertThat(responseCountDto.getLicenseCount()).isEqualTo(1);
        Assertions.assertThat(responseCountDto.getUserCount()).isEqualTo(1);
        Assertions.assertThat(responseCountDto.getProblemCount()).isEqualTo(2);
    }
}