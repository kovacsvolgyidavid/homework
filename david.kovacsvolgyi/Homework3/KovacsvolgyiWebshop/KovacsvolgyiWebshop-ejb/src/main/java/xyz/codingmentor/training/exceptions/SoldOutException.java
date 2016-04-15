package xyz.codingmentor.training.exceptions;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class SoldOutException extends RuntimeException {

    public SoldOutException(String message) {
        super(message);
    }

    public SoldOutException() {
        super();
    }

}
