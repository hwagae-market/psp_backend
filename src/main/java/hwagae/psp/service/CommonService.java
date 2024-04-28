package hwagae.psp.service;

import hwagae.psp.dto.response.ResponseCountDto;
import hwagae.psp.entity.CategoryType;
import hwagae.psp.repository.CategoryRepository;
import hwagae.psp.repository.ProblemRepository;
import hwagae.psp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonService {

    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final CategoryRepository categoryRepository;

    public ResponseCountDto getCountInfo() {
        Long userCount = userRepository.count();
        Long problemCount = problemRepository.count();
        Long licenseCount = categoryRepository.countByCategoryType(CategoryType.LICENSE);

        return new ResponseCountDto(userCount, problemCount, licenseCount);
    }
}
