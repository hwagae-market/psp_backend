package hwagae.psp.service;

import hwagae.psp.dto.request.RequestAnswerDto;
import hwagae.psp.dto.request.RequestAnswerListDto;
import hwagae.psp.dto.request.RequestWorkbookDto;
import hwagae.psp.dto.response.ResponseAnswerDto;
import hwagae.psp.dto.response.ResponseWorkbookDto;
import hwagae.psp.entity.Category;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.User;
import hwagae.psp.entity.Workbook;
import hwagae.psp.repository.CategoryRepository;
import hwagae.psp.repository.WorkbookRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkbookService {

    private final WorkbookRepository workbookRepository;
    private final ProblemService problemService;
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public void saveWorkbook(RequestWorkbookDto workbook) {
        Category category = categoryRepository.findById(workbook.getCategoryId()).orElseThrow();
        Workbook saved = Workbook.builder().category(category).build();

        List<Problem> problemList
                = workbook.getProblemList().stream().map(p -> problemService.saveProblem(p, saved)).toList();


        saved.setProblemList(problemList);
    }

    public ResponseWorkbookDto findById(Long id) {
        Optional<Workbook> optionalWorkbook = workbookRepository.findById(id);
        if (optionalWorkbook.isEmpty())
            throw new RuntimeException();

        Workbook workbook = optionalWorkbook.get();
        return new ResponseWorkbookDto(workbook);
    }

    public ResponseAnswerDto solvedProblems(RequestAnswerListDto answerListDto) {
        int rightCnt = 0;
        int wrongCnt = 0;
        ArrayList<Long> rightProblemNum = new ArrayList<>();
        ArrayList<Long> wrongProblemNum = new ArrayList<>();

        for (RequestAnswerDto answer : answerListDto.getAnswerList()) {
            if (problemService.solved(answer)) {
                rightCnt += 1;
                rightProblemNum.add(answer.getProblemId());
            } else {
                wrongCnt += 1;
                wrongProblemNum.add(answer.getProblemId());
            }
        }

        return ResponseAnswerDto.builder()
                .rightCount(rightCnt)
                .wrongCount(wrongCnt)
                .rightProblemList(rightProblemNum)
                .wrongProblemList(wrongProblemNum)
                .build();
    }

    public List<ResponseWorkbookDto> searchByCategory(String keyword) {
        Optional<Category> categoryOptional = categoryRepository.findByName(keyword);
        List<ResponseWorkbookDto> result = new ArrayList<>();


        if (categoryOptional.isEmpty())
            return result;

        List<Workbook> searchResult = workbookRepository.findAllByCategory(categoryOptional.get());
        result = searchResult.stream().map(ResponseWorkbookDto::new).toList();

        return result;
    }

    /**
     * 사용자가 문제집을 구독
     *
     * @param id       - 대상 워크북 번호
     * @param request  - 인증 토큰을 헤더에서 받음
     * @param response
     */
    public void subscribe(Long id, HttpServletRequest request, HttpServletResponse response) {
        String jwtToken = request.getHeader("X-AUTH-TOKEN");
        User user = userService.parsingJwtToken(jwtToken);

        Optional<Workbook> optionalWorkbook = workbookRepository.findById(id);

        if (optionalWorkbook.isEmpty())
            throw new NoSuchElementException();


        user.subscribeWorkbook(optionalWorkbook.get());
    }

    /**
     * 문제집 구독 취소 기능
     *
     * @param user - 대상 유저
     * @param id   - 제거할 문제집 번호
     */
    public void disSubscribe(User user, Long id) {
        Optional<Workbook> optWorkbook = workbookRepository.findById(id);
        if (optWorkbook.isEmpty())
            throw new NoSuchElementException();

        Workbook workbook = optWorkbook.get();
        user.getScribeWorkbook().remove(workbook);
    }
}
