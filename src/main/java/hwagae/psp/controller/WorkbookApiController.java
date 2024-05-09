package hwagae.psp.controller;

import hwagae.psp.config.annotation.RequiredAuthenticate;
import hwagae.psp.dto.request.RequestAnswerListDto;
import hwagae.psp.dto.request.RequestWorkbookDto;
import hwagae.psp.dto.response.ResponseAnswerDto;
import hwagae.psp.dto.response.ResponseWorkbookDto;
import hwagae.psp.service.UserService;
import hwagae.psp.service.WorkbookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workbook")
@RequiredArgsConstructor
public class WorkbookApiController {

    private final WorkbookService workbookService;
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveWorkbook(@RequestBody RequestWorkbookDto workbookDto) {
        workbookService.saveWorkbook(workbookDto);
        return ResponseEntity.ok("저장 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWorkbookDto> getWorkbook(@PathVariable Long id) {
        ResponseWorkbookDto workbookDto = workbookService.findById(id);
        return ResponseEntity.ok(workbookDto);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ResponseWorkbookDto>> searchByCategory(@RequestParam String keyword) {
        List<ResponseWorkbookDto> result = workbookService.searchByCategory(keyword);

        return ResponseEntity.ok(result);
    }

    /**
     * 문제집 정답 채점
     */
    @PostMapping("/answer/submit")
    public ResponseEntity<ResponseAnswerDto> solvedWorkbook(@RequestBody RequestAnswerListDto answerListDto) {
        ResponseAnswerDto solvedProblems = workbookService.solvedProblems(answerListDto);
        return ResponseEntity.ok(solvedProblems);
    }

    @RequiredAuthenticate
    @GetMapping("/subscribe")
    public ResponseEntity<String> subscribeWorkbook(@RequestParam Long id, HttpServletResponse response, HttpServletRequest request) {
        workbookService.subscribe(id, request, response);

        return ResponseEntity.ok("구독 성공");
    }

    @RequiredAuthenticate
    @GetMapping("/cancel/subscribe")
    public ResponseEntity<String> disScribeWorkBook(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response) {
        workbookService.disSubscribe(userService.parsingJwtToken(request.getHeader("X-AUTH-TOKEN")), id);

        return ResponseEntity.ok("구독 취소 완료");
    }
}
