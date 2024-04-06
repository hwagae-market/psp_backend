package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

/**
 * 주관식의 경우, 보기가 주어지지 않으므로 부모 클래스의 데이터만 있으면 됨
 */
@Entity
@DiscriminatorValue("subjective")
public class SubjectiveProblem extends Problem {

}