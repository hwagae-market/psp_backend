package hwagae.psp.controller;

import hwagae.psp.dto.request.RequestAnswerDto;
import hwagae.psp.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problem")
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(problemService.getAllProblemCount());
    }

    @PostMapping("/answer/submit")
    public ResponseEntity<String> problemSolved(@RequestBody RequestAnswerDto answerDto) {
        boolean result = problemService.solved(answerDto);

        if(result)
            return ResponseEntity.ok("정답입니다");

        return ResponseEntity.ok("오답입니다.");
    }
}
