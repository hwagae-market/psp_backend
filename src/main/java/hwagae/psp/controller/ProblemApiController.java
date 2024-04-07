package hwagae.psp.controller;

import hwagae.psp.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem")
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(problemService.getAllProblemCount());
    }
}
