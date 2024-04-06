package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("multiple")
public class MultipleProblem extends Problem {
    List<Selector> selector;

    // 객관식 문제 선택지
    public static class Selector {
        int num;
        String content;
    }
}