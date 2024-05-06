package hwagae.psp.dto.response;

import hwagae.psp.entity.Complain;
import lombok.Data;

@Data
public class ResponseComplainDto {
    private String reason;//신고 사유
    private String detail;//자세한 신고 내용

    public ResponseComplainDto(Complain complain) {
        this.reason = complain.getReason();
        this.detail = complain.getDetail();
    }
}
