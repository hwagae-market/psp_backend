package hwagae.psp.aop;

import hwagae.psp.exception.PermissionDeniedException;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 해당 서비스는 스프링 Aop기술을 사용해서
 * 특정 어노테이션이 사용된 메소드에서
 * 사용자 권한을 체크하여 권한이 있는 경우에만
 * 실행될 수 있도록 합니다.
 */
@Aspect
@Component
public class AuthenticationAopService {

    @Before("@annotation(hwagae.psp.annotation.RequiredAuthenticate) && args(request,..)")
    public void validateUserAuthentication(JoinPoint joinPoint, HttpServletRequest request) {
        String token = request.getHeader("X-AUTH-TOKEN");

        if (!isValidate(token)) {
            throw new PermissionDeniedException();
        }
    }

    /**
     * 테스트용 토큰 검증 로직
     * 테스트용도로만 사용 실사용 X
     */
    public boolean isValidate(String token) {
        return token != null && !token.isBlank();
    }
}
