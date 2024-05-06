package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * 여러 문제가 포함된 문제집 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workbook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Setter
    private User user;

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<Problem> problemList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
