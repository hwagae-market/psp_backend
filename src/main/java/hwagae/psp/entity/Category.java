package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 문제집, 문제 카테고리 정보
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;//대분류 카테고리 타입
    private String name;//카테고리 명
}
