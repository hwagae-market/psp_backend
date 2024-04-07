package hwagae.psp.dto.request;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.Workbook;
import lombok.Data;

import java.util.List;

@Data
public class RequestWorkbookDto {

    Category category;
    List<RequestProblemDto> problemList;

    public Workbook toEntity() {
        return Workbook.builder()
                .category(category)
                .build();
    }
}
