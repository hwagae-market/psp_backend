package hwagae.psp.controller;

import hwagae.psp.dto.response.ResponseCountDto;
import hwagae.psp.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 다른 엔티티와 연관성이 적거나, Select외엔 다른
 * 연산이 이루어지지 않는 경우에 해당 컨트롤러에서 처리
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class CommonApiController {

    private final CommonService commonService;

    /**
     * 메인 페이지에서 출력한 카운트 정보
     *
     * @return ResponseCountDto
     */
    @GetMapping("/count")
    public ResponseEntity<ResponseCountDto> getCountInfo() {
        log.info("CALL THIS METHOD");
        return ResponseEntity.ok(commonService.getCountInfo());
    }
}
