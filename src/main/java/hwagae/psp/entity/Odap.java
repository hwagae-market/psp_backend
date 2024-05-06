package hwagae.psp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

/**
 * 오답노트 문제 & 해설 엔티티
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Odap {
    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    @Setter
    private Problem problem;//오답노트에 등록한 문제

    private String submit;//사용자가 제출한 정보(주관식, 객관식도 String input)
}
