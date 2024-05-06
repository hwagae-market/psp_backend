package hwagae.psp.dto.request;

import lombok.Data;

import java.util.List;

/**
 * 오답노트 생성 요청 Dto
 */
@Data
public class RequestOdapNoteDto {
    private Long userId;//사용자의 PK
    private List<RequestOdapDto> odapList;//사용자가 입력한 개별 오답 정보
}
