package hu.codingmentor.Exception;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class ValidationException extends RuntimeException{
    
    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException() {
        super();
    }

}
