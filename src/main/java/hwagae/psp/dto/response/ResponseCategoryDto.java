package hwagae.psp.dto.response;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.CategoryType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseCategoryDto {
    private CategoryType categoryType;//대분류 카테고리 타입
    private String name;//카테고리 명

    public ResponseCategoryDto(Category category) {
        this.categoryType = category.getCategoryType();
        this.name = category.getName();
    }
}
