package xyz.codingmentor.Exception;

/**
 *
 * @author Dénes László <denes.laszlo.88@gmail.com>
 */
public class IdNotMatchException extends RuntimeException {

    public IdNotMatchException(String msg) {
        super(msg);
    }

    public IdNotMatchException() {
        super();
    }

}
