package week4.exception.myexception;

public class myRuntimeException extends RuntimeException{

    public myRuntimeException() {
    }

    public myRuntimeException(String message) {
        super(message);
    }

    public myRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public myRuntimeException(Throwable cause) {
        super(cause);
    }
}
