package hwagae.psp.dto.response;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.Workbook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseWorkbookDto {
    private List<ResponseProblem> problemList;
    private Category category;

    public ResponseWorkbookDto(Workbook workbook) {
        this.problemList = workbook.getProblemList().stream().map(ResponseProblem::new).toList();
        this.category = workbook.getCategory();
    }
}
