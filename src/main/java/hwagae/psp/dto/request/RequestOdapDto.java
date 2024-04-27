package hwagae.psp.dto.request;

import lombok.Data;

/**
 * 개별 오답노트 생성 DTO
 */
@Data
public class RequestOdapDto {
    private Long problemId;//대상 문제의 PK
    private String answer;//사용자가 입력한 답안
}
