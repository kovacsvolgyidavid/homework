package xyz.codingmentor.training.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@ApplicationException
public class CheckoutFailedException extends RuntimeException {

    public CheckoutFailedException() {
        super();
    }

    public CheckoutFailedException(String msg) {
        super(msg);
    }

}
