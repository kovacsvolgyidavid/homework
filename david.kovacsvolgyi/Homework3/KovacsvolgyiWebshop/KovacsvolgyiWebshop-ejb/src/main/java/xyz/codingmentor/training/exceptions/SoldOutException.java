package xyz.codingmentor.training.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@ApplicationException
public class SoldOutException extends RuntimeException {

    public SoldOutException(String message) {
        super(message);
    }

    public SoldOutException() {
        super();
    }

}
