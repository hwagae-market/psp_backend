package hwagae.psp.dto.request;

import lombok.Data;

@Data
public class RequestComplainDto {
    private Long problemId;
    private String reason;
    private String detail;
}
