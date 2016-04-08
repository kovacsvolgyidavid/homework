package xyz.codingmentor.Exception;

/**
 *
 * @author Denes Laszlo <denes.laszlo.88@gmail.com>
 */
public class ValidationException extends RuntimeException{
    
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException() {
        super();
    }

}
