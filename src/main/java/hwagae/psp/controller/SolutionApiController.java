package hwagae.psp.controller;

import hwagae.psp.dto.request.RequestSolutionDto;
import hwagae.psp.dto.response.ResponseSolutionDto;
import hwagae.psp.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solution")
@RequiredArgsConstructor
public class SolutionApiController {

    private final SolutionService solutionService;

    @GetMapping("/{problemId}")
    public ResponseEntity<ResponseSolutionDto> getSolution(@PathVariable("problemId") Long id) {
        return ResponseEntity.ok(solutionService.findById(id));
    }

    @PostMapping("/update/{problemId}")
    public ResponseEntity<String> updateSolution(
            @RequestBody RequestSolutionDto requestSolutionDto,
            @PathVariable("problemId") Long id) {


        solutionService.updateSolution(requestSolutionDto, id);

        return ResponseEntity.ok("수정 완료");
    }
}
