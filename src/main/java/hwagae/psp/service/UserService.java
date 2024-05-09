package hwagae.psp.service;

import hwagae.psp.dto.request.LoginUserDto;
import hwagae.psp.dto.request.RegisterUserDto;
import hwagae.psp.entity.User;
import hwagae.psp.exception.FailLoginRequestException;
import hwagae.psp.exception.NoSuchUserException;
import hwagae.psp.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Value("${validate.secret-key}")
    private String secretKey;

    public void save(RegisterUserDto registerUser) {
        // 비밀번호 인코딩
        registerUser.setPassword(encoder.encode(registerUser.getPassword()));

        userRepository.save(registerUser.toEntity());
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty())
            throw new NoSuchUserException();

        return optionalUser.get();
    }

    public ResponseEntity<Object> login(LoginUserDto login, HttpServletResponse response) {
        Optional<User> optionalUser = userRepository.findByUsername(login.getUsername());

        if (optionalUser.isEmpty())
            return ResponseEntity.ok(new FailLoginRequestException("해당하는 계정 정보가 존재하지 않습니다."));

        User loginUser = optionalUser.get();
        if (!encoder.matches(login.getPassword(), loginUser.getPassword())) {
            return ResponseEntity.ok(new FailLoginRequestException("비밀번호가 일치하지 않습니다"));
        }

        response.setHeader("X-AUTH-TOKEN", publishToken(loginUser));
        return ResponseEntity.ok("로그인 성공");
    }

    private String publishToken(User login) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder()
                .setIssuer("psp")
                .setSubject("PSP-AUTHENTICATE")
                .setAudience(login.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60)))
                .setIssuedAt(new Date())
                .setId(UUID.randomUUID().toString())
                .signWith(
                        key, SignatureAlgorithm.HS256
                )
                .compact();

        return jwt;
    }

    public User parsingJwtToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build().parseClaimsJws(token);


        String username = claimsJws.getBody().getAudience();
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty())
            throw new NoSuchUserException();

        return optionalUser.get();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElse(null);

    }
}
