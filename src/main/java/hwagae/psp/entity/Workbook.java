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
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Setter
    private User user;

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<Problem> problemList;

    @OneToOne
    private Category category;
}
