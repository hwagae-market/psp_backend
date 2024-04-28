package hwagae.psp.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestWorkbookDto {

    Long categoryId;
    List<RequestProblemDto> problemList;
}
