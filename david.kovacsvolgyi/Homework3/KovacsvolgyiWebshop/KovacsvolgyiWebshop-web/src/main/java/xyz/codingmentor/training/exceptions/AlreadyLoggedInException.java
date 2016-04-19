package xyz.codingmentor.training.exceptions;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class AlreadyLoggedInException extends RuntimeException {

    public AlreadyLoggedInException(String msg) {
        super(msg);
    }

    public AlreadyLoggedInException() {
        super();
    }

}
