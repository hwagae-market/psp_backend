package hwagae.psp.config.aop;

import hwagae.psp.entity.User;
import hwagae.psp.exception.PermissionDeniedException;
import hwagae.psp.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/**
 * 해당 서비스는 스프링 Aop기술을 사용해서
 * 특정 어노테이션이 사용된 메소드에서
 * 사용자 권한을 체크하여 권한이 있는 경우에만
 * 실행될 수 있도록 합니다.
 */
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationAopService {

    private final UserService userService;

    @Value("${validate.secret-key}")
    private String secretKey;

    @Before("@annotation(hwagae.psp.config.annotation.RequiredAuthenticate)")
    public void validateUserAuthentication(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;

        // 서블릿 리퀘스트 탐색
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
                break;
            }
        }

        if (request == null) {
            throw new NoSuchElementException();
        }

        String token = request.getHeader("X-AUTH-TOKEN");

        if (token == null || token.isEmpty()) {
            throw new PermissionDeniedException();
        }

        if (!isValidate(token)) {
            throw new PermissionDeniedException();
        }
    }

    private boolean isValidate(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build().parseClaimsJws(token);


        String username = claimsJws.getBody().getAudience();
        User user = userService.findByUsername(username);

        return user != null;
    }
}
