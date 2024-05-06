package hwagae.psp.exception;

public class FailLoginRequestException extends RuntimeException {
    public FailLoginRequestException() {
        super();
    }

    public FailLoginRequestException(String message) {
        super(message);
    }

    public FailLoginRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailLoginRequestException(Throwable cause) {
        super(cause);
    }

    protected FailLoginRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
