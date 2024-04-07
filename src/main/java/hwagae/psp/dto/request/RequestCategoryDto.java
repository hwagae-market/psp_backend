package hwagae.psp.dto.request;

import hwagae.psp.entity.Category;
import hwagae.psp.entity.CategoryType;
import lombok.Data;

@Data
public class RequestCategoryDto {
    private String categoryType;
    private String name;

    public Category toEntity() {
        return Category.builder()
                .categoryType(CategoryType.valueOf(categoryType))
                .name(name)
                .build();
    }
}
