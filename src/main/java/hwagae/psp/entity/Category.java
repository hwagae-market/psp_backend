package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Category extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;//대분류 카테고리 타입
    private String name;//카테고리 명
}
