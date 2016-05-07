package exception;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class HasNotEnoughMoneyException extends RuntimeException {

    public HasNotEnoughMoneyException() {
        super();
    }

    public HasNotEnoughMoneyException(String string) {
        super(string);
    }

}
