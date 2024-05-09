package hwagae.psp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 문제에 대한 신고 정보
 */
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;//신고 사유
    private String detail;//자세한 신고 내용

    @ManyToOne
    @JsonIgnore
    private Problem problem;
}
