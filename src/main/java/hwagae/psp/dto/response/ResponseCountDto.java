package hwagae.psp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 메인 페이지에서 보여줄 카운트 정보
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCountDto {
    private Long userCount = 0L;//등록된 사용자 개수
    private Long problemCount = 0L;//등록된 문제 개수
    private Long licenseCount = 0L;//등록된 자격증 카테고리 내 개수
}
