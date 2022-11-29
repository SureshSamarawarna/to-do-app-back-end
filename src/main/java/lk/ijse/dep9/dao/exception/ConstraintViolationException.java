package lk.ijse.dep9.dao.exception;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String message) {
        super(message);
    }

    public ConstraintViolationException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
