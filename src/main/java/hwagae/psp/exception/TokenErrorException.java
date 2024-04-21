package hwagae.psp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
public class TokenErrorException extends Exception{

    public TokenErrorException(String message) {
        super(message);
        log.error("TokenErrorException ,Time={}, message={}", LocalDateTime.now(), message);
    }
}
