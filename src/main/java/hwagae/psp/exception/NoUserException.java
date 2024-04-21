package hwagae.psp.exception;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class NoUserException extends Exception{

    public NoUserException(String message) {
        super(message);
        log.error("NoUserException : ,Time={}, message={}", LocalDateTime.now(), message);
    }
}
