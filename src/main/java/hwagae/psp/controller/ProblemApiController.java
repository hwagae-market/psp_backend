package hwagae.psp.controller;

import hwagae.psp.dto.request.RequestAnswerDto;
import hwagae.psp.dto.request.RequestComplainDto;
import hwagae.psp.dto.request.UpdateProblemDto;
import hwagae.psp.dto.response.ResponseSolutionDto;
import hwagae.psp.service.ComplainService;
import hwagae.psp.service.ProblemService;
import hwagae.psp.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problem")
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;
    private final SolutionService solutionService;
    private final ComplainService complainService;

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(problemService.getAllProblemCount());
    }

    @PostMapping("/answer/submit")
    public ResponseEntity<String> problemSolved(@RequestBody RequestAnswerDto answerDto) {
        boolean result = problemService.solved(answerDto);

        if (result)
            return ResponseEntity.ok("정답입니다");

        return ResponseEntity.ok("오답입니다.");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProblem(@RequestBody UpdateProblemDto updateProblemDto) {
        problemService.updateProblem(updateProblemDto);

        return ResponseEntity.ok("업데이트 완료");
    }

    /**
     * @param complain = 사용자가 접수한 문제 신고 내용
     */
    @PostMapping("/send/complain")
    public ResponseEntity<String> sendComplain(@RequestBody RequestComplainDto complain) {
        complainService.createComplain(complain);

        return ResponseEntity.ok("신고 접수가 완료되었습니다.");
    }

    @GetMapping("/solution")
    public ResponseEntity<ResponseSolutionDto> getProblemSolution(@RequestParam Long pid) {
        ResponseSolutionDto responseSolutionDto = solutionService.findById(pid);

        return ResponseEntity.ok(responseSolutionDto);
    }
}
