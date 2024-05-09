package hwagae.psp.controller;

import hwagae.psp.config.annotation.RequiredAuthenticate;
import hwagae.psp.dto.request.RequestOdapNoteDto;
import hwagae.psp.dto.response.ResponseOdapNoteDto;
import hwagae.psp.service.OdapNoteService;
import hwagae.psp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 오답노트 컨트롤러
 * 오답노트와 관련된 호출은 이곳에서
 * 진행해주세요.
 */
@RestController
@RequestMapping("/odap")
@RequiredArgsConstructor
public class OdapApiController {

    private final OdapNoteService odapNoteService;
    private final UserService userService;

    /**
     * 사용자가 등록한 전체 오답노트 정보를 출력
     *
     * @param id - 사용자 Pk -> 추후 시큐리티 권한으로 체크할 예정
     * @return List<ResponseOdapNoteDto> 사용자가 등록한 오답노트 리스트
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ResponseOdapNoteDto>> getUserOdapNoteList(@PathVariable Long id) {
        return ResponseEntity.ok(odapNoteService.findOdapNoteByUser(id));
    }

    /**
     * 개별 오답노트 정보에 대해서 출력
     *
     * @param id - 오답노트 PK 정보
     * @return ResponseOdapNoteDto - 특정 오답노트 정보
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseOdapNoteDto> getOdapNote(@PathVariable Long id) {
        return ResponseEntity.ok(odapNoteService.findOdapNoteById(id));
    }

    /**
     * 오답노트 생성 요청
     *
     * @param odapNote - 생성할 오답노트 정보
     * @return
     */
    @PostMapping
    public ResponseEntity<String> createOdapNote(@RequestBody RequestOdapNoteDto odapNote) {
        odapNoteService.saveOdapNote(odapNote);

        return ResponseEntity.ok("오답노트가 생성되었습니다.");
    }

    @GetMapping("/remove/note")
    @RequiredAuthenticate
    public ResponseEntity<String> removeOdapNote(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response) {
        odapNoteService.removeOdapNote(userService.parsingJwtToken(request.getHeader("X-AUTH-TOKEN")), id);

        return ResponseEntity.ok("오답노트가 제거되었습니다.");
    }

}
