package hwagae.psp.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 사용자 권한이 필요하다는 것을 알리는 어노테이션
 * 메소드에 붙히면 해당 메소드는 로그인을 체크한 후에
 * 실행되는 기능
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredAuthenticate {
}
